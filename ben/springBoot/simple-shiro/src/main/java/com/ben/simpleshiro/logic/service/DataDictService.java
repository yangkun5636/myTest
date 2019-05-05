package com.ben.simpleshiro.logic.service;

import com.ben.simpleshiro.logic.bo.DataDict;
import com.ben.simpleshiro.logic.bo.SimplePage;
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
