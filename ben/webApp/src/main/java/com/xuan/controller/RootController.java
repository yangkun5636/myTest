package com.xuan.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class RootController {

    @RequestMapping(value = {"/", "index.html"})
    public String index(ModelMap map) {
        map.put("index", "this is index");
        return "index";
    }
}
