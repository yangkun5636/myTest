package com.ben.simpleshiro.logic.service;

import com.ben.simpleshiro.logic.bo.Role;
import com.ben.simpleshiro.logic.bo.SimplePage;
import com.github.pagehelper.Page;

import java.util.List;

public interface RoleService {

    List<Role> list();

    Page<Role> page(SimplePage page);

    Role save(Role dict);

    Role query(Integer id);

    int update(Role dict);

    int delete(Integer id);
}
