package com.ben.shiro.service.impl;

import com.ben.shiro.mapper.DataDictMapper;
import com.ben.shiro.pojo.bo.DataDict;
import com.ben.shiro.pojo.bo.SimplePage;
import com.ben.shiro.service.DataDictService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author yangkun
 */
@Service
public class DataDictServiceImpl implements DataDictService {

    @Autowired
    private DataDictMapper mapper;

    @Override
    public String string() {
        return "hello this is dataDictService string";
    }

    @Override
    public String select1() {
        return mapper.select1();
    }

    @Override
    public List<DataDict> list() {
        return mapper.list();
    }

    @Override
    public Page<DataDict> page(SimplePage page) {
        PageHelper.startPage(page.getPageNum(), page.getPageSize());
        return mapper.page();
    }

    @Override
    public DataDict save(DataDict dict) {
        int save = mapper.save(dict);
        return dict;
    }

    @Override
    public DataDict query(Integer id) {
        return mapper.query(id);
    }

    @Override
    public int update(DataDict dict) {
        return mapper.update(dict);
    }

    @Override
    public int delete(Integer id) {
        return mapper.delete(id);
    }
}
