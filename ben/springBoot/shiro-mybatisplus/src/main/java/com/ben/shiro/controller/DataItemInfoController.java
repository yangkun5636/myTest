package com.ben.shiro.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.ben.shiro.pojo.bo.DataDict;
import com.ben.shiro.service.DataDictService;
import com.ben.shiro.util.PageUtil;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author yangkun
 * @since 2019-04-24
 */
@Controller
@RequestMapping("/dataItem")
public class DataItemInfoController {

    @Autowired
    private DataDictService dataDictService;


    @RequestMapping(value = "/dictList", method = RequestMethod.GET)
    public String dictList(HttpServletRequest request, Model model) {
        IPage<DataDict> page = dataDictService.query().orderByAsc("id").page(PageUtil.getPageParam(request));
        model.addAttribute("list", page.getRecords());
        return "dictList";
    }

}

