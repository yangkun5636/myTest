package com.ben.simpleshiro.logic.mapper;

import com.ben.simpleshiro.logic.bo.Role;
import com.github.pagehelper.Page;

import java.util.List;

public interface RoleMapper {

    List<Role> list();

    Page<Role> page();

    int save(Role dict);

    Role query(Integer id);

    int update(Role dict);

    int delete(Integer id);

}
