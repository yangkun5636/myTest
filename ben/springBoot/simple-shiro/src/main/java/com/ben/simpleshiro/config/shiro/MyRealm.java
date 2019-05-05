package com.ben.simpleshiro.config.shiro;

import com.ben.simpleshiro.logic.bo.Permission;
import com.ben.simpleshiro.logic.bo.Role;
import com.ben.simpleshiro.logic.bo.User;
import com.ben.simpleshiro.logic.service.LoginService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.SimpleByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author yangkun
 */
public class MyRealm extends AuthorizingRealm {
    @Autowired
    private LoginService loginService;

    /**
     *
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
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
        return null;
    }

}
