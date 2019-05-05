package com.ben.shiro.service.impl;

import com.ben.shiro.mapper.LoginMapper;
import com.ben.shiro.pojo.bo.Permission;
import com.ben.shiro.pojo.bo.Role;
import com.ben.shiro.pojo.bo.User;
import com.ben.shiro.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author yangkun
 */
@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private LoginMapper loginMapper;

    @Override
    public User getUserByName(String username) {
        return loginMapper.getUserByName(username);
    }

    @Override
    public List<Role> getUserRole(User user) {
        return loginMapper.getUserRole(user.getId());
    }

    @Override
    public List<Permission> getUserPermissions(List<Role> roles) {
        return loginMapper.getUserPermissions(roles);
    }
}
