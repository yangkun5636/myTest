package com.ben.simpleshiro.config.shiro;

import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.AccessControlFilter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * @author yangkun
 */
@Slf4j
public class MyAccessControlFilter extends AccessControlFilter {
    @Override
    protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) throws Exception {
        System.out.println("=========MyAccessControlFilter  isAccessAllowed  =========");
        //获得认证主体
        Subject subject = getSubject(request, response);
        //获得当前请求的 url
        String url = getPathWithinApplication(request);
        boolean permitted = subject.isPermitted(url);
        System.out.println("MyAccessControlFilter  isAccessAllowed : permitted:" + permitted);
        return true;
    }

    @Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
        System.out.println("=========MyAccessControlFilter     onAccessDenied   =========");
        return true;
    }
}