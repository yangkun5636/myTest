package com.ben.simpleshiro.logic.service.impl;

import com.ben.simpleshiro.logic.bo.Permission;
import com.ben.simpleshiro.logic.bo.SimplePage;
import com.ben.simpleshiro.logic.service.PermissionService;
import com.github.pagehelper.Page;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author yangkun
 */
@Service
public class PermissionServiceImpl implements PermissionService {
    @Override
    public List<Permission> list() {
        return null;
    }

    @Override
    public Page<Permission> page(SimplePage page) {
        return null;
    }

    @Override
    public Permission save(Permission dict) {
        return null;
    }

    @Override
    public Permission query(Integer id) {
        return null;
    }

    @Override
    public int update(Permission dict) {
        return 0;
    }

    @Override
    public int delete(Integer id) {
        return 0;
    }
}
