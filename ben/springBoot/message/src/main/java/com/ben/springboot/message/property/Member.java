package com.ben.springboot.message.property;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

/**
 * @author yangkun
 * @see
 * @since
 */
@Data
@Component
@PropertySource(value = "classpath:member.properties")
@ConfigurationProperties(prefix = "account.member")
public class Member {

    @Autowired
    public Member(Environment environment) {
        this.port = environment.getProperty("account.port");
    }

    private String name;
    private String mail;
    private String phone;
    private String port;
}
