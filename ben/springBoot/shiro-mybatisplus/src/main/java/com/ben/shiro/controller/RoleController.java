package com.ben.shiro.controller;

import com.ben.shiro.pojo.bo.Role;
import com.ben.shiro.pojo.bo.SimplePage;
import com.ben.shiro.service.RoleService;
import com.github.pagehelper.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author yangkun
 */
@RestController
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private RoleService service;

    @RequestMapping("/list")
    public List<Role> list() {
        return service.list();
    }

    @RequestMapping("/page")
    public Page<Role> page(SimplePage page) {
        return service.page(page);
    }

    @RequestMapping("/save")
    public Role save(Role dict) {
        return service.save(dict);
    }

    @RequestMapping("/query")
    public Role query(Integer id) {
        return service.query(id);
    }

    @RequestMapping("/update")
    public int update(Role dict) {
        return service.update(dict);
    }

    @RequestMapping("/delete")
    public int delete(Integer id) {
        return service.delete(id);
    }
}
