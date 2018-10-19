package com.xuan.controller;

import com.alibaba.fastjson.JSONObject;
import com.xuan.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
    public JSONObject test() {
        String test = testService.test();
        return JSONObject.parseObject(test);
    }
}
