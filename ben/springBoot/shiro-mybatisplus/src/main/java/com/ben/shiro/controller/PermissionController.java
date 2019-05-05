package com.ben.shiro.controller;

import com.ben.shiro.pojo.bo.Permission;
import com.ben.shiro.pojo.bo.SimplePage;
import com.ben.shiro.service.PermissionService;
import com.github.pagehelper.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author yangkun
 */
@RestController
@RequestMapping("/permission")
public class PermissionController {

    @Autowired
    private PermissionService service;

    @RequestMapping("/list")
    public List<Permission> list() {
        return service.list();
    }

    @RequestMapping("/page")
    public Page<Permission> page(SimplePage page) {
        return service.page(page);
    }

    @RequestMapping("/save")
    public Permission save(Permission dict) {
        return service.save(dict);
    }

    @RequestMapping("/query")
    public Permission query(Integer id) {
        return service.query(id);
    }

    @RequestMapping("/update")
    public int update(Permission dict) {
        return service.update(dict);
    }

    @RequestMapping("/delete")
    public int delete(Integer id) {
        return service.delete(id);
    }
}
