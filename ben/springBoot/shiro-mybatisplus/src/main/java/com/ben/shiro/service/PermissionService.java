package com.ben.shiro.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ben.shiro.pojo.bo.SysPermission;

import java.util.List;

/**
 * @author yangkun
 */
public interface PermissionService extends IService<SysPermission> {
    List<SysPermission> getPermissionList();
}
