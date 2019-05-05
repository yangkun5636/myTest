package com.ben.simpleshiro.logic.mapper;

import com.ben.simpleshiro.logic.bo.DataItem;
import com.github.pagehelper.Page;

import java.util.List;

public interface DataItemMapper {

    List<DataItem> list();

    Page<DataItem> page();

    int save(DataItem dict);

    DataItem query(Integer id);

    int update(DataItem dict);

    int delete(Integer id);

}
