package com.sunzi.logbackdemo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
@Slf4j
public class LogbackDemoApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(LogbackDemoApplication.class, args);

        int length = context.getBeanDefinitionNames().length;
        log.trace("SpringBoot 初始化{}个Bean",length);
        log.debug("SpringBoot 初始化{}个Bean",length);
        log.info("SpringBoot 初始化{}个Bean",length);
        log.warn("SpringBoot 初始化{}个Bean",length);
        log.error("SpringBoot 初始化{}个Bean",length);
        try {
            int i = 0;
            int j = 1 / i;
        } catch (Exception e) {
            log.error("【SpringBootDemoLogbackApplication】启动异常：", e);
        }
    }

}
