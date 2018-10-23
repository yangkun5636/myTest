package com.xuan.controller;

import com.alibaba.fastjson.JSONObject;
import com.xuan.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/")
public class RootController {

    @Autowired
    TestService testService;

    @RequestMapping(value = {"/", "index.html"})
    public String index(ModelMap map) {
        map.put("index", "this is index");
        return "index";
    }


    @ResponseBody
    @RequestMapping("test")
    public String test(HttpServletRequest request, HttpServletResponse response, ModelMap map) {
        String test = testService.test();
        return test;
    }
}
