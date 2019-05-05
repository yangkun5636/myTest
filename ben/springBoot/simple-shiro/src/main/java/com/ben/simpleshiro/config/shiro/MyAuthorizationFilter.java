package com.ben.simpleshiro.config.shiro;

import org.apache.shiro.web.filter.authz.AuthorizationFilter;
import org.springframework.stereotype.Component;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * @author yangkun
 */
@Component
public class MyAuthorizationFilter extends AuthorizationFilter {
    @Override
    protected String getName() {
        return "myFilter";
    }

    @Override
    protected boolean isAccessAllowed(ServletRequest servletRequest, ServletResponse servletResponse, Object o) throws Exception {
        System.out.println("-------------------MyAuthorizationFilter------------------");
        return true;
    }
}
