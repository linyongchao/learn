package my.learn.controller;

import my.learn.utils.DateUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
@RequestMapping("/test")
public class TestController {

    @RequestMapping("/getNow")
    @ResponseBody
    public String getNow() {
        SimpleDateFormat sdf = new SimpleDateFormat(DateUtils.DEFAULT_PATTERN);
        return sdf.format(new Date());
    }
}
