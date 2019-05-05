package com.ben.shiro.mapper;

import com.ben.shiro.pojo.bo.Permission;
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
