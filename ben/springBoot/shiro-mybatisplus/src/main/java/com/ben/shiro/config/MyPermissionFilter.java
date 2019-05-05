package com.ben.shiro.config;

import org.apache.shiro.web.filter.authz.PermissionsAuthorizationFilter;
import org.springframework.stereotype.Component;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;

/**
 * @author yangkun
 */
@Component
public class MyPermissionFilter extends PermissionsAuthorizationFilter {
    @Override
    public boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) throws IOException {
        System.out.println("===================MyPermissionFilter====================");
        return super.isAccessAllowed(request, response, mappedValue);
    }

}
