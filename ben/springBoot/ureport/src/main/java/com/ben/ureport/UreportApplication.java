package com.ben.ureport;

import com.bstek.ureport.console.UReportServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@ImportResource("classpath:ureport-console-context.xml")
@PropertySource("classpath:application.properties")
public class UreportApplication {

    public static void main(String[] args) {
        SpringApplication.run(UreportApplication.class, args);
    }

    @Bean
    public ServletRegistrationBean getBean() {
        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(new UReportServlet(), "/ureport/*");
        return servletRegistrationBean;
    }
}
