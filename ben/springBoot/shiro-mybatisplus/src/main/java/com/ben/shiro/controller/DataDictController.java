package com.ben.shiro.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.ben.shiro.pojo.bo.DataDict;
import com.ben.shiro.service.DataDictService;
import com.ben.shiro.util.PageUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * <p>
 * 数据字典 前端控制器
 * </p>
 *
 * @author yangkun
 * @since 2019-04-24
 */
@Api("数据字典")
@RestController
@RequestMapping("/data-dict")
public class DataDictController {

    @Autowired
    private DataDictService dataDictService;

    @ApiOperation("数据字典分页查询")
    @GetMapping("/listPage")
    @RequiresPermissions("dataDict:list")
    public IPage listPage(HttpServletRequest request) {
        SecurityUtils.getSubject().checkPermission("dataDict:list");
        IPage<DataDict> page = dataDictService.query().orderByAsc("id").page(PageUtil.getPageParam(request));
        return page;
    }


}

