package com.ben.shiro.service;

import com.ben.shiro.pojo.bo.Permission;
import com.ben.shiro.pojo.bo.SimplePage;
import com.github.pagehelper.Page;

import java.util.List;

/**
 * @author yangkun
 */
public interface PermissionService {


    List<Permission> list();

    Page<Permission> page(SimplePage page);

    Permission save(Permission dict);

    Permission query(Integer id);

    int update(Permission dict);

    int delete(Integer id);
}
