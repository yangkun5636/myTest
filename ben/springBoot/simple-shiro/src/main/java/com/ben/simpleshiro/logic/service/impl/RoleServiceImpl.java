package com.ben.simpleshiro.logic.service.impl;

import com.ben.simpleshiro.logic.bo.Role;
import com.ben.simpleshiro.logic.bo.SimplePage;
import com.ben.simpleshiro.logic.service.RoleService;
import com.github.pagehelper.Page;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author yangkun
 */
@Service
public class RoleServiceImpl implements RoleService {
    @Override
    public List<Role> list() {
        return null;
    }

    @Override
    public Page<Role> page(SimplePage page) {
        return null;
    }

    @Override
    public Role save(Role dict) {
        return null;
    }

    @Override
    public Role query(Integer id) {
        return null;
    }

    @Override
    public int update(Role dict) {
        return 0;
    }

    @Override
    public int delete(Integer id) {
        return 0;
    }
}
