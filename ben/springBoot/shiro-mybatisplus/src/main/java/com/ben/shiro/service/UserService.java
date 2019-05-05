package com.ben.shiro.service;

import com.ben.shiro.pojo.bo.SimplePage;
import com.ben.shiro.pojo.bo.User;
import com.github.pagehelper.Page;

import java.util.List;

public interface UserService {

    List<User> list();

    Page<User> page(SimplePage page);

    int save(User user);

    User query(Integer id);

    int update(User user);

    int delete(Integer id);
}
