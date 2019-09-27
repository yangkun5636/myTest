package com.ben.springboot.message.property;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @author yangkun
 * @see
 * @since
 */
@Data
@Component
@PropertySource("classpath:member.properties")
@ConfigurationProperties(prefix = "account")
public class Account {

    private Map<String, String> member;
}
