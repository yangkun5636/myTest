package com.ben.shiro.service.impl;

import com.ben.shiro.mapper.UserMapper;
import com.ben.shiro.pojo.bo.SimplePage;
import com.ben.shiro.pojo.bo.User;
import com.ben.shiro.service.UserService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author yangkun
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper mapper;

    @Override
    public List<User> list() {
        return mapper.list();
    }

    @Override
    public Page<User> page(SimplePage page) {
        PageHelper.startPage(page.getPageNum(), page.getPageSize());
        return mapper.page();
    }

    @Override
    public int save(User user) {
        int save = mapper.save(user);
        System.out.println("save：" + save);
        return user.getId();
    }

    @Override
    public User query(Integer id) {
        return mapper.query(id);
    }

    @Override
    public int update(User user) {
        return mapper.update(user);
    }

    @Override
    public int delete(Integer id) {
        return mapper.delete(id);
    }
}
