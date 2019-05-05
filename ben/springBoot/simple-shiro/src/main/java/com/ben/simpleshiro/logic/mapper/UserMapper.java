package com.ben.simpleshiro.logic.mapper;

import com.ben.simpleshiro.logic.bo.User;
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

