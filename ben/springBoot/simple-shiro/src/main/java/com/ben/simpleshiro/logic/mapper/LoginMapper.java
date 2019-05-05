package com.ben.simpleshiro.logic.mapper;

import com.ben.simpleshiro.logic.bo.Permission;
import com.ben.simpleshiro.logic.bo.Role;
import com.ben.simpleshiro.logic.bo.User;

import java.util.List;

/**
 * @author yangkun
 */
public interface LoginMapper {
    User getUserByName(String username);

    List<Role> getUserRole(Integer id);

    List<Permission> getUserPermissions(List<Role> roles);
}
