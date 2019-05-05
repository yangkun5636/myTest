package com.ben.boot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author yangkun
 */

@ServletComponentScan
@SpringBootApplication
@ComponentScan(basePackages = {"com.ben.boot.controller", "com.ben.boot.service"})
@MapperScan(basePackages = {"com.ben.boot.mapper"})
public class BootApplication {

    public static void main(String[] args) {
        SpringApplication.run(BootApplication.class, args);
    }

}
