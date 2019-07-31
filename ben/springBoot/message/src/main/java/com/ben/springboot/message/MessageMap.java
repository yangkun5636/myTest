package com.ben.springboot.message;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.util.HashMap;
import java.util.Map;

/**
 * @author yangkun
 * @see
 * @since
 */
@Configuration
//@Component
@PropertySource(value = "classpath:message.properties")
@ConfigurationProperties(prefix = "test")
//@EnableConfigurationProperties(MessageMap.class)
public class MessageMap {

    private Map<String, String> limitSizeMap = new HashMap<>();

    public Map<String, String> getLimitSizeMap() {
        return limitSizeMap;
    }

    public void setLimitSizeMap(Map<String, String> map) {
        this.limitSizeMap = map;
    }
}
