package my.learn.controller;

import my.learn.annotationtest.TimeLog;
import my.learn.utils.DateUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
@RequestMapping("/test")
public class TestController {

    @RequestMapping("/getNow")
    @ResponseBody
    @TimeLog(description = "获取当前时间")
    public String getNow(@RequestParam(value = "userId") String userId) {
        SimpleDateFormat sdf = new SimpleDateFormat(DateUtils.DEFAULT_PATTERN);
        System.out.println("userId=" + userId);
        return sdf.format(new Date());
    }
}
