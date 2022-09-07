package com.sunz.demo.controller;

import cn.hutool.core.lang.Dict;
import com.sunz.demo.property.ApplicationProperty;
import com.sunz.demo.property.DeveloperProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.support.PropertiesLoaderUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * @author Slience
 * @version 1.0
 */
@RestController
public class PropertyController {
    private final ApplicationProperty applicationProperty;
    private final DeveloperProperty developerProperty;

    @Autowired
    public PropertyController(ApplicationProperty applicationProperty, DeveloperProperty developerProperty) {
        this.applicationProperty = applicationProperty;
        this.developerProperty = developerProperty;
    }

    /**
     * 将参数封装对应类
     * @return
     */
    @GetMapping("/property")
    public Dict index() {
        return Dict.create().set("applicationProperty", applicationProperty).set("developerProperty", developerProperty);
    }

    /**
     * 通过Environment读取配置 获取端口号
     */
    @Autowired
    Environment environment;

    @GetMapping("/propertyByEnv")
    @ResponseBody
    public String ReadPropertyByEnvironment(){
        Map<String, String> map = new HashMap<>();
        map.put("port",environment.getProperty("server.port"));
        map.put("java_home",environment.getProperty("JAVA_HOME"));
        return map.toString();
    }

    /**
     * 通过Value读取配置 获取端口号
     */
    @Value("${server.port}")
    public String port;

    @GetMapping("/propertyByValue")
    @ResponseBody
    public String ReadPropertyByValue(){
        Map<String, String> map = new HashMap<>();
        map.put("port",port);
        return map.toString();
    }

    @GetMapping("/propertyByResource")
    @ResponseBody
    public String ReadProperty() throws IOException {
        ClassPathResource resource = new ClassPathResource("test.properties");
        Properties properties = PropertiesLoaderUtils.loadProperties(resource);
        Map<String, String> map = new HashMap<>();
        map.put("logging.level.root",properties.getProperty("logging.level.root"));
        return map.toString();
    }




}
