package com.ben.boot.filter;

import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * @author yangkun
 */
@Component
@WebFilter(filterName = "requestSecureFilter", urlPatterns = {"/wx/*"})
public class RequestSecureFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("===========================init===========================");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("===========================filter===========================");
    }

    @Override
    public void destroy() {
        System.out.println("===========================destroy===========================");
    }
}
