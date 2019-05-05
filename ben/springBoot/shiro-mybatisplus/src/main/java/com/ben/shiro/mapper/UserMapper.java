package com.ben.shiro.mapper;

import com.ben.shiro.pojo.bo.User;
import com.github.pagehelper.Page;

import java.util.List;

/**
 * @author yangkun
 */
public interface UserMapper {
    List<User> list();

    Page<User> page();

    int save(User user);

    User query(Integer id);

    int update(User user);

    int delete(Integer id);
}

