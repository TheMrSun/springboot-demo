package com.sunz.demo.hello;

import cn.hutool.core.util.StrUtil;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Slience
 * @version 1.0
 */
@Controller
public class HelloController {

    @GetMapping("/hello")
    @ResponseBody
    public String sayHello(@RequestParam(required = false,name = "who") String who){
        if(StrUtil.isBlank(who)){
            who = "world";
        }
        return StrUtil.format("Hello, {}!", who);
    }
}
