package com.ben.shiro;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


/**
 * @author yangkun
 * swagger ： http://localhost:8080/swagger/index.html
 * <p>
 * springboot中的swagger：http://localhost:8080/swagger-ui.html
 * <p>
 * druid数据库监控　：http://localhost:8080/druid/index.html
 */
@SpringBootApplication
@EnableSwagger2
@EnableTransactionManagement
@MapperScan(basePackages = {"com.ben.shiro.mapper"})
public class ShiroApplication {

    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(ShiroApplication.class);
        application.setBannerMode(Banner.Mode.OFF);
        application.run(args);
//        SpringApplication.run(ShiroApplication.class, args);
    }

}
