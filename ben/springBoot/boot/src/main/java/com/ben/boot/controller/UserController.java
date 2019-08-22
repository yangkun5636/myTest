package com.ben.boot.controller;

import com.alibaba.fastjson.JSONObject;
import com.ben.boot.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @author yangkun
 */
@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/demo")
    public String demo(String name, HttpServletRequest request, ModelMap modelMap) {
        Map<String, String[]> parameterMap = request.getParameterMap();
        log.error("parameterMap:{}", parameterMap);
        modelMap.put("age", parameterMap.get("age"));
        return "hello demo\r\nparameterMap:" + parameterMap.toString();
    }

    @GetMapping("/list")
    public JSONObject userList() {
        Map<String, Object> param = new HashMap<>();
        return userService.userList(param);
    }
}
