package shiro.config;

import org.apache.shiro.web.filter.AccessControlFilter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * @author yangkun
 */
public class KickOutSessionFilter extends AccessControlFilter {
    @Override
    protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) {
        System.out.println("=====================kickOutFilter:isAccessAllowed=========");
        return true;
    }

    @Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) {
        System.out.println("=====================kickOutFilter:onAccessDenied=========");
        return true;
    }
}
