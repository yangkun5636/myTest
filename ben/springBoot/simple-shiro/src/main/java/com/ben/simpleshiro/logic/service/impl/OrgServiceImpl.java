package com.ben.simpleshiro.logic.service.impl;

import com.ben.simpleshiro.logic.bo.Org;
import com.ben.simpleshiro.logic.bo.SimplePage;
import com.ben.simpleshiro.logic.service.OrgService;
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
