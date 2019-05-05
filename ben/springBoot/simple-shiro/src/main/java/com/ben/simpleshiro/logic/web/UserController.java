package com.ben.simpleshiro.logic.web;

import com.ben.simpleshiro.logic.bo.SimplePage;
import com.ben.simpleshiro.logic.bo.User;
import com.ben.simpleshiro.logic.service.UserService;
import com.github.pagehelper.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author yangkun
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService service;

    @RequestMapping("/list")
    public List<User> list() {
        return service.list();
    }

    @RequestMapping("/page")
    public Page<User> page(Model model, SimplePage page) {
        return service.page(page);
    }

    @RequestMapping("/save")
    public int save(User user) {
        return service.save(user);
    }

    @RequestMapping("/query")
    public User query(Integer id) {
        return service.query(id);
    }

    @RequestMapping("/update")
    public int update(User user) {
        return service.update(user);
    }

    @RequestMapping("/delete")
    public int delete(Integer id) {
        return service.delete(id);
    }

}
