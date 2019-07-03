package com.ben.simpleshiro.config.shiro;

import com.ben.simpleshiro.logic.bo.Permission;
import com.ben.simpleshiro.logic.bo.Role;
import com.ben.simpleshiro.logic.bo.User;
import com.ben.simpleshiro.logic.service.LoginService;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.SimpleByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author yangkun
 */
@Slf4j
public class MyRealm extends AuthorizingRealm {
    @Autowired
    private LoginService loginService;
    @Autowired
    private StringRedisTemplate redisTemplate;

    /**
     *
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        log.debug("登录!");
        String username = (String) authenticationToken.getPrincipal();
        User user = loginService.getUserByName(username);
        if (null == user) {
            throw new UnknownAccountException("用户名不存在!");
        }
        List<Role> roles = loginService.getUserRole(user);
        List<Permission> permissions = loginService.getUserPermissions(roles);
        user.setRoles(roles);
        user.setPermissions(permissions);
        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(user, user.getPassword(), getName());
        info.setCredentialsSalt(SimpleByteSource.Util.bytes("yangkun"));
        return info;
    }


    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        if (null == principalCollection) {
            throw new AuthenticationException("principalCollection is null");
        }

        //获得经过认证的主体信息
        User user = (User) principalCollection.getPrimaryPrincipal();
        List<Role> roles = user.getRoles();
        List<String> strRoles = roles.stream().map(Role::getRoleCode).distinct().collect(Collectors.toList());
        List<Permission> permissions = user.getPermissions();
        List<String> strPers = permissions.stream().map(Permission::getPermission).distinct().collect(Collectors.toList());
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        info.addRoles(strRoles);
        info.addStringPermissions(strPers);
        return info;
    }

}
