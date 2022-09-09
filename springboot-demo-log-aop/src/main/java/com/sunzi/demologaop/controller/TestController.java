package com.sunzi.demologaop.controller;

import cn.hutool.core.lang.Dict;
import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONUtil;
import com.sunzi.demologaop.common.annotation.OperationAspectLog;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * @author Slience
 * @version 1.0
 */
@Slf4j
@Controller
public class TestController {

    /**
     * GET测试
     * @param who
     * @return
     */
    @GetMapping("/test")
    @ResponseBody
    public Dict test(String who) {
        return Dict.create().set("who", StrUtil.isBlank(who) ? "me" : who);
    }

    /**
     *  post测试 json方法
     * @param map 请求的json参数
     * @return {@link Dict}
     */
    @PostMapping("/testJson")
    @ResponseBody
    public Dict testJson(@RequestBody Map<String, Object> map) {

        final String jsonStr = JSONUtil.toJsonStr(map);
        log.info(jsonStr);
        return Dict.create().set("json", map);
    }

    @GetMapping("/annotationTest")
    @OperationAspectLog(operationDesc = "测试注解log")
    @ResponseBody
    public Dict testAnntation(String name) {
        return Dict.create().set("name", StrUtil.isBlank(name) ? "me" : name);
    }
}
