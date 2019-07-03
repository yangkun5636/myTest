package com.ben.simpleshiro.config.shiro;

import com.ben.simpleshiro.logic.bo.User;
import com.ben.simpleshiro.logic.service.LoginService;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authz.AuthorizationFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.Serializable;

/**
 * @author yangkun
 */
@Slf4j
public class MyAuthorizationFilter extends AuthorizationFilter {

    @Autowired
    private LoginService loginService;
    @Autowired
    private StringRedisTemplate redisTemplate;

    /**
     * 鉴定用户是否登录状态
     */
    @Override
    protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object o) throws Exception {
        Subject subject = getSubject(request, response);
        Session session = subject.getSession();
        log.info("进入myAuth Filter session:{}", session);
        User user = (User) subject.getPrincipal();
        Serializable sessionId = session.getId();

        if (user == null) {
            String username = redisTemplate.opsForValue().get(sessionId);
            if (username == null) {
                log.info("根据sessionId[{}]没有查询到用户名，登录已超时!", sessionId);
                subject.logout();
            } else {
                String cacheSessionId = redisTemplate.opsForValue().get(username);
                if (!sessionId.equals(cacheSessionId)) {
                    log.info("sessionId[{}]用户被踢出!", sessionId);
                    subject.logout();
                } else {
                    user = loginService.getUserByName(username);
                }
            }
        } else {
            String cacheUsername = redisTemplate.opsForValue().get(sessionId);
            if (cacheUsername == null) {
                log.info("用户登录超时sessionId[{}]", sessionId);
                subject.logout();
            } else {
                String cacheSessionId = redisTemplate.opsForValue().get(cacheUsername);
                if (!sessionId.equals(cacheSessionId)) {
                    log.info("sessionId[{}]用户被踢出!", sessionId);
                    subject.logout();
                }
            }
        }
        return true;
    }

}
