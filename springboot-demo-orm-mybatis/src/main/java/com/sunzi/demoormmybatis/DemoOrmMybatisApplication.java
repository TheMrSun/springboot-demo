package com.sunzi.demoormmybatis;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;


@MapperScan(basePackages = {"com.sunzi.demoormmybatis.demo.mapper"})
@SpringBootApplication
public class DemoOrmMybatisApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoOrmMybatisApplication.class, args);
    }

}
