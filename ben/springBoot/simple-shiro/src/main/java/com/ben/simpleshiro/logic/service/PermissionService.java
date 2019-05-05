package com.ben.simpleshiro.logic.service;

import com.ben.simpleshiro.logic.bo.Permission;
import com.ben.simpleshiro.logic.bo.SimplePage;
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
