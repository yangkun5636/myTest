package com.ben.shiro.controller;

import com.ben.shiro.pojo.bo.User;
import com.ben.shiro.service.LoginService;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author yangkun
 */
@Slf4j
@Api("登录")
@Controller
@RequestMapping("/")
public class LoginController {
    @Autowired
    private LoginService loginService;

    @RequestMapping(value = {"", "login"}, method = RequestMethod.GET)
    public String login() {
        return "login";
    }

    @RequestMapping(value = "login", method = RequestMethod.POST)
    public String login(String username, String password, Model model) {
        log.info("username:{};password:{}", username, password);
        User user;

        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        subject.login(token);
        user = loginService.getUserByName(username);
        model.addAttribute("user", user);
        return "index";
    }
}
