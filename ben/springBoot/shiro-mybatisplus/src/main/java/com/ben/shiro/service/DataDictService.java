package com.ben.shiro.service;

import com.ben.shiro.pojo.bo.DataDict;
import com.ben.shiro.pojo.bo.SimplePage;
import com.github.pagehelper.Page;

import java.util.List;

/**
 * @author yangkun
 */
public interface DataDictService {
    /**
     * 测试String方法
     */
    String string();

    String select1();

    List<DataDict> list();

    Page<DataDict> page(SimplePage page);

    DataDict save(DataDict dict);

    DataDict query(Integer id);

    int update(DataDict dict);

    int delete(Integer id);
}
