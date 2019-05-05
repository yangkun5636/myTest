package com.ben.shiro.service;

import com.ben.shiro.pojo.bo.SysPermission;
import com.ben.shiro.pojo.bo.SysRole;
import com.ben.shiro.pojo.bo.SysUser;

import java.util.List;

/**
 * @author yangkun
 */
public interface LoginService {
    SysUser getUserByName(String username);

    List<SysRole> getUserRole(Integer userId);

    List<SysPermission> getPermissionList(List<String> roleCodes);

}
