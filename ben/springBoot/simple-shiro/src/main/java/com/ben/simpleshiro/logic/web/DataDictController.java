package com.ben.simpleshiro.logic.web;

import com.ben.simpleshiro.logic.bo.DataDict;
import com.ben.simpleshiro.logic.bo.SimplePage;
import com.ben.simpleshiro.logic.service.DataDictService;
import com.github.pagehelper.Page;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author yangkun
 */
@RestController
@RequestMapping("/dataDict")
public class DataDictController {

    @Autowired
    private DataDictService service;

    @RequestMapping("/list")
    @RequiresRoles("dataDict")
    @RequiresPermissions("dataDict:list")
    public List<DataDict> list() {
        return service.list();
    }

    @RequestMapping("/page")
    public Page<DataDict> page(SimplePage page) {
        return service.page(page);
    }

    @RequestMapping("/save")
    public DataDict save(DataDict dict) {
        return service.save(dict);
    }

    @RequestMapping("/query")
    public DataDict query(Integer id) {
        return service.query(id);
    }

    @RequestMapping("/update")
    public int update(DataDict dict) {
        return service.update(dict);
    }

    @RequestMapping("/delete")
    public int delete(Integer id) {
        return service.delete(id);
    }


}
