package com.ben.shiro.service;

import com.ben.shiro.pojo.bo.Role;
import com.ben.shiro.pojo.bo.User;
import com.ben.shiro.pojo.bo.Permission;

import java.util.List;

public interface LoginService {
    User getUserByName(String username);

    List<Role> getUserRole(User user);

    List<Permission> getUserPermissions(List<Role> roles);
}
