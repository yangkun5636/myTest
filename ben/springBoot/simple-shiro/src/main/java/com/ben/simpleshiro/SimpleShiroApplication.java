package com.ben.simpleshiro;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author yangkun
 */
@SpringBootApplication
@MapperScan(basePackages = "com.ben.simpleshiro.logic.mapper")
public class SimpleShiroApplication {

    public static void main(String[] args) {
        SpringApplication.run(SimpleShiroApplication.class, args);
    }

}
