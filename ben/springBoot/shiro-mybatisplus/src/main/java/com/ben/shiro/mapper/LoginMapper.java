package com.ben.shiro.mapper;

import com.ben.shiro.pojo.bo.Permission;
import com.ben.shiro.pojo.bo.Role;
import com.ben.shiro.pojo.bo.User;

import java.util.List;

/**
 * @author yangkun
 */
public interface LoginMapper {
    User getUserByName(String username);

    List<Role> getUserRole(Integer id);

    List<Permission> getUserPermissions(List<Role> roles);
}
