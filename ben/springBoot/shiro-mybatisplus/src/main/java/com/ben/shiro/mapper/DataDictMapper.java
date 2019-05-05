package com.ben.shiro.mapper;

import com.ben.shiro.pojo.bo.DataDict;
import com.github.pagehelper.Page;

import java.util.List;

public interface DataDictMapper {

    String select1();

    List<DataDict> list();

    Page<DataDict> page();

    int save(DataDict dict);

    DataDict query(Integer id);

    int update(DataDict dict);

    int delete(Integer id);

}
