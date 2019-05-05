package com.ben.shiro.service;

import com.ben.shiro.pojo.bo.DataItem;
import com.ben.shiro.pojo.bo.SimplePage;
import com.github.pagehelper.Page;

import java.util.List;

public interface DataItemService {

    List<DataItem> list();

    Page<DataItem> page(SimplePage page);

    DataItem save(DataItem dict);

    DataItem query(Integer id);

    int update(DataItem dict);

    int delete(Integer id);
}
