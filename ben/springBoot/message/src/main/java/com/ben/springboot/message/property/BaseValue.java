package com.ben.springboot.message.property;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @author yangkun
 * @see
 * @since
 */
@Data
@Component
@PropertySource("classpath:config.properties")
public class BaseValue {
    @Value("${spring.data.url}")
    private String url;
    @Value("${spring.data.username}")
    private String username;
}
