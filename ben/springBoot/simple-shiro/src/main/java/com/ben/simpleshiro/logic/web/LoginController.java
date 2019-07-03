package com.ben.simpleshiro.logic.web;

import com.ben.simpleshiro.logic.bo.User;
import com.ben.simpleshiro.logic.service.LoginService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @author yangkun
 */
@RestController
public class LoginController {

    @Autowired
    private LoginService loginService;
    @Autowired
    private StringRedisTemplate redisTemplate;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(String username, String password) {
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        subject.login(token);
        return "登录成功!";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public Map<String, Object> getLogin(HttpServletRequest request, String username, String password) {
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        Subject subject = SecurityUtils.getSubject();
        subject.login(token);
        Session session = subject.getSession();
        User user = loginService.getUserByName(username);

        redisTemplate.opsForValue().set(username, session.getId().toString(), 10, TimeUnit.MINUTES);
        redisTemplate.opsForValue().set(session.getId().toString(), username, 10, TimeUnit.MINUTES);
        Map<String, Object> result = new HashMap<>();
        result.put("message", "登录成功");
        result.put("data", new Date());
        return result;
    }
}
