package com.ben.shiro.service.impl;

import com.ben.shiro.pojo.bo.Org;
import com.ben.shiro.pojo.bo.SimplePage;
import com.ben.shiro.service.OrgService;
import com.github.pagehelper.Page;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author yangkun
 */
@Service
public class OrgServiceImpl implements OrgService {
    @Override
    public List<Org> list() {
        return null;
    }

    @Override
    public Page<Org> page(SimplePage page) {
        return null;
    }

    @Override
    public Org save(Org dict) {
        return null;
    }

    @Override
    public Org query(Integer id) {
        return null;
    }

    @Override
    public int update(Org dict) {
        return 0;
    }

    @Override
    public int delete(Integer id) {
        return 0;
    }
}
