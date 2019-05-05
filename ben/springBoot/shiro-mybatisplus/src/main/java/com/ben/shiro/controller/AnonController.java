package com.ben.shiro.controller;

import com.ben.shiro.service.DataDictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @author yangkun
 */
@RestController
@RequestMapping("/anon")
public class AnonController {

    @Autowired
    private DataDictService dataDictService;

    @RequestMapping("/demo1")
    public String demo1(HttpServletRequest request) {
        return "demo1";
    }


    @RequestMapping("/demo2")
    public String demo2() {
        return dataDictService.string();
    }

    @RequestMapping("/select1")
    public String select1() {
        return dataDictService.select1();
    }
}
