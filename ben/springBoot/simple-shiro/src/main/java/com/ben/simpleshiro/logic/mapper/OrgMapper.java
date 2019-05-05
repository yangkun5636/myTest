package com.ben.simpleshiro.logic.mapper;

import com.ben.simpleshiro.logic.bo.Org;
import com.github.pagehelper.Page;

import java.util.List;

public interface OrgMapper {

    List<Org> list();

    Page<Org> page();

    int save(Org dict);

    Org query(Integer id);

    int update(Org dict);

    int delete(Integer id);

}
