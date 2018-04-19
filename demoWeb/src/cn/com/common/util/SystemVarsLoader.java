package cn.com.common.util;


import javax.servlet.ServletContext;

import org.springframework.stereotype.Component;
import org.springframework.web.context.ServletContextAware;


@Component
public class SystemVarsLoader implements ServletContextAware {

    public void setServletContext(ServletContext servletContext) {
        servletContext.setAttribute("ctx", servletContext.getContextPath());
        System.out.println("Loading System Varibles from DB start...");
        System.out.println("Loading System Varibles from DB end.");
    }

}
