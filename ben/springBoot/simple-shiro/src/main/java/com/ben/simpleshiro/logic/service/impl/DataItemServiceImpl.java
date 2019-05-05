package com.ben.simpleshiro.logic.service.impl;

import com.ben.simpleshiro.logic.bo.DataItem;
import com.ben.simpleshiro.logic.bo.SimplePage;
import com.ben.simpleshiro.logic.mapper.DataItemMapper;
import com.ben.simpleshiro.logic.service.DataItemService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author yangkun
 */
@Service
public class DataItemServiceImpl implements DataItemService {

    @Autowired
    private DataItemMapper mapper;


    @Override
    public List<DataItem> list() {
        return mapper.list();
    }

    @Override
    public Page<DataItem> page(SimplePage page) {
        PageHelper.startPage(page.getPageNum(), page.getPageSize());
        return mapper.page();
    }

    @Override
    public DataItem save(DataItem dict) {
        int save = mapper.save(dict);
        return dict;
    }

    @Override
    public DataItem query(Integer id) {
        return mapper.query(id);
    }

    @Override
    public int update(DataItem dict) {
        return mapper.update(dict);
    }

    @Override
    public int delete(Integer id) {
        return mapper.delete(id);
    }
}
