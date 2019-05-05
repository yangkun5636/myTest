package com.ben.simpleshiro.logic.mapper;

import com.ben.simpleshiro.logic.bo.Permission;
import com.github.pagehelper.Page;

import java.util.List;

public interface PermissionMapper {

    List<Permission> list();

    Page<Permission> page();

    int save(Permission dict);

    Permission query(Integer id);

    int update(Permission dict);

    int delete(Integer id);

}
