package com.ben.shiro.controller;

import cn.hutool.json.JSONUtil;
import com.ben.shiro.pojo.bo.SysPermission;
import com.ben.shiro.service.PermissionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author yangkun
 */
@Api("permission")
@RestController
@RequestMapping("/p")
public class PermissionController {

    @Autowired
    private PermissionService service;

    @ApiOperation("查询权限")
    @GetMapping("/get")
    @RequiresPermissions("permission:retrieve")
    public String get() {
        return "有permission:retrieve这个权限的用户才能访问，不然访问不了";
    }

    @ApiOperation("查询权限")
    @GetMapping("/getList")
    @RequiresPermissions("permission:query")
    public String getPermissionList(Model model) {
        List<SysPermission> permissions = service.getPermissionList();
        model.addAttribute("list", permissions);
        return JSONUtil.toJsonStr(model);
    }
}
