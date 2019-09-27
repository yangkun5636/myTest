package com.ben.springboot.message.property;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ConfigTest {
    @Autowired
    Member member;
    @Autowired
    Account account;
    @Autowired
    Config config;
    @Autowired
    BaseValue value;

    @Test
    public void run() {
        System.out.println(member);
        System.out.println(config);
        System.out.println(account);
        System.out.println(value);
    }

}