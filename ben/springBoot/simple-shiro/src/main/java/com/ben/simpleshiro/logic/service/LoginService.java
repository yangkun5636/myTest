package com.ben.simpleshiro.logic.service;

import com.ben.simpleshiro.logic.bo.Permission;
import com.ben.simpleshiro.logic.bo.Role;
import com.ben.simpleshiro.logic.bo.User;

import java.util.List;

public interface LoginService {
    User getUserByName(String username);

    List<Role> getUserRole(User user);

    List<Permission> getUserPermissions(List<Role> roles);
}
