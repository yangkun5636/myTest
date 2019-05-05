package com.ben.simpleshiro.logic.web;

import com.ben.simpleshiro.logic.bo.DataItem;
import com.ben.simpleshiro.logic.bo.SimplePage;
import com.ben.simpleshiro.logic.service.DataItemService;
import com.github.pagehelper.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author yangkun
 */
@RestController
@RequestMapping("/dataItem")
public class DataItemController {
    @Autowired
    private DataItemService service;

    @RequestMapping("/list")
    public List<DataItem> list() {
        return service.list();
    }

    @RequestMapping("/page")
    public Page<DataItem> page(SimplePage page) {
        return service.page(page);
    }

    @RequestMapping("/save")
    public DataItem save(DataItem dict) {
        return service.save(dict);
    }

    @RequestMapping("/query")
    public DataItem query(Integer id) {
        return service.query(id);
    }

    @RequestMapping("/update")
    public int update(DataItem dict) {
        return service.update(dict);
    }

    @RequestMapping("/delete")
    public int delete(Integer id) {
        return service.delete(id);
    }
}
