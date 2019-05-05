package com.ben.shiro.mapper;

import com.ben.shiro.pojo.bo.SysPermission;
import com.ben.shiro.pojo.bo.SysRole;
import com.ben.shiro.pojo.bo.SysUser;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @author yangkun
 */
@Repository
public interface LoginMapper {

    List<SysRole> getUserRole(Integer userId);

    SysUser getUserByName(String username);

    List<SysPermission> getPermissionList(Map<String, Object> param);
}
