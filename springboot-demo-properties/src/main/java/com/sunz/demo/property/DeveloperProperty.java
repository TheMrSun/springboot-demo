package com.sunz.demo.property;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @author Slience
 * @version 1.0
 */
@Data
@ConfigurationProperties(prefix = "developer")
@PropertySource(value = {"classpath:application-dev.yml"})
@Component
public class DeveloperProperty {
    private String name;
    private String phoneNumber;
}
