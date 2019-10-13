package my.learn.controller;

import my.learn.utils.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.File;

/**
 * 图片读取
 *
 * @author lin
 * @return
 * @date 2019/10/13 16:05
 **/
@Controller
@RequestMapping("/picture")
public class PictureController {
    private Logger logger = LoggerFactory.getLogger(PictureController.class);
    /**
     * 基本路径
     **/
    private static String PATH_BASE;
    /**
     * 图片数组
     **/
    private static String[] PATH_ARRAY;
    /**
     * 图片指针
     **/
    private static int INDEX = 0;

    /**
     * 跳转配置页面（争取删除）
     *
     * @param
     * @return
     * @author lin
     * @date 2019/10/13 16:04
     **/
    @RequestMapping("/hello")
    public String hello() {
        return "hello";
    }

    /**
     * 初始化
     *
     * @param model
     * @param path
     * @return
     * @author lin
     * @date 2019/10/13 16:03
     **/
    @RequestMapping("/init")
    public String init(Model model, String path) {
        PATH_BASE = path;
        File file = new File(PATH_BASE);
        PATH_ARRAY = file.list();
        model.addAttribute("pic", read());
        return "show";
    }

    /**
     * 读取下一张图片
     *
     * @param model
     * @return
     * @author lin
     * @date 2019/10/13 16:03
     **/
    @RequestMapping("/next")
    public String next(Model model) {
        INDEX++;
        String result = read();
        if (result == null) {
            INDEX = PATH_ARRAY.length;
            model.addAttribute("alert", "图片已经读取结束");
        } else {
            model.addAttribute("pic", result);
        }
        return "show";
    }

    /**
     * 读取下一张图片
     *
     * @param model
     * @return
     * @author lin
     * @date 2019/10/13 16:03
     **/
    @RequestMapping("/pre")
    public String pre(Model model) {
        INDEX--;
        String result = read();
        if (result == null) {
            INDEX = -1;
            model.addAttribute("alert", "图片已经读取结束");
        } else {
            model.addAttribute("pic", result);
        }
        return "show";
    }

    /**
     * 重置指针
     *
     * @param model
     * @return
     * @author lin
     * @date 2019/10/13 16:03
     **/
    @RequestMapping("/reset")
    public String reset(Model model) {
        INDEX = 0;
        model.addAttribute("pic", read());
        return "show";
    }

    /**
     * 读取图片
     *
     * @param
     * @return
     * @author lin
     * @date 2019/10/13 16:01
     **/
    private String read() {
        if (INDEX < 0 || INDEX > PATH_ARRAY.length - 1) {
            return null;
        }
        String path = PATH_BASE + File.separator + PATH_ARRAY[INDEX];
        String result = "data:image;base64,";
        try {
            result += FileUtils.toBase64(path);
        } catch (Exception e) {
            logger.error("文件 {} 读取异常：{}", path, e);
        }
        return result;
    }

}
