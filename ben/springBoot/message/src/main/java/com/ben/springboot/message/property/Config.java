package com.ben.springboot.message.property;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @author yangkun
 * @see
 * @since
 */
@Data
@Component
@ConfigurationProperties("spring.data")
@PropertySource("classpath:config.properties")
public class Config {
    private String url;
    private String username;
}
