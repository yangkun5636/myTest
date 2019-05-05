package com.ben.shiro.service.impl;

import com.ben.shiro.mapper.LoginMapper;
import com.ben.shiro.pojo.bo.SysPermission;
import com.ben.shiro.pojo.bo.SysRole;
import com.ben.shiro.pojo.bo.SysUser;
import com.ben.shiro.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author yangkun
 */
@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private LoginMapper loginMapper;

    @Override
    public SysUser getUserByName(String username) {
        SysUser user = loginMapper.getUserByName(username);

        return user;
    }

    @Override
    public List<SysRole> getUserRole(Integer userId) {
        return loginMapper.getUserRole(userId);
    }

    @Override
    public List<SysPermission> getPermissionList(List<String> roleCodes) {
        Map<String, Object> param = new HashMap<>();
        param.put("roleCodes", roleCodes);
        List<SysPermission> permissions = loginMapper.getPermissionList(param);
        return permissions;
    }
}
