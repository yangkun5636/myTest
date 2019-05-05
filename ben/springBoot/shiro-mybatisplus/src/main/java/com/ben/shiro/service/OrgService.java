package com.ben.shiro.service;

import com.ben.shiro.pojo.bo.Org;
import com.ben.shiro.pojo.bo.SimplePage;
import com.github.pagehelper.Page;

import java.util.List;

/**
 * @author yangkun
 */
public interface OrgService {


    List<Org> list();

    Page<Org> page(SimplePage page);

    Org save(Org dict);

    Org query(Integer id);

    int update(Org dict);

    int delete(Integer id);
}
