package com.ben.simpleshiro.logic.web;

import com.ben.simpleshiro.logic.bo.Org;
import com.ben.simpleshiro.logic.bo.SimplePage;
import com.ben.simpleshiro.logic.service.OrgService;
import com.github.pagehelper.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author yangkun
 */
@RestController
@RequestMapping("/org")
public class OrgController {
    @Autowired
    private OrgService service;

    @RequestMapping("/list")
    public List<Org> list() {
        return service.list();
    }

    @RequestMapping("/page")
    public Page<Org> page(SimplePage page) {
        return service.page(page);
    }

    @RequestMapping("/save")
    public Org save(Org dict) {
        return service.save(dict);
    }

    @RequestMapping("/query")
    public Org query(Integer id) {
        return service.query(id);
    }

    @RequestMapping("/update")
    public int update(Org dict) {
        return service.update(dict);
    }

    @RequestMapping("/delete")
    public int delete(Integer id) {
        return service.delete(id);
    }
}
