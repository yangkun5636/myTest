package com.ben.shiro.config;

import com.ben.shiro.pojo.bo.Permission;
import com.ben.shiro.pojo.bo.Role;
import com.ben.shiro.pojo.bo.User;
import com.ben.shiro.service.LoginService;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authc.*;
import org.apache.shiro.authc.credential.PasswordService;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author yangkun
 * 自定义验证
 */
@Slf4j
public class MyRealm extends AuthorizingRealm {

    @Autowired
    private LoginService loginService;

    @Autowired
    private PasswordService passwordService;

    @Autowired
    private StringRedisTemplate redisTemplate;

    private static final String SALT = "yangkun";

    /**
     * 定义如何获取用户的角色和权限的逻辑，给shiro做权限判断
     *
     * @param principals
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        log.info("授权");
        String username = principals.getPrimaryPrincipal().toString();
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        User user = loginService.getUserByName(username);

        List<Role> roles = loginService.getUserRole(user);
        List<String> roleCodes = roles.stream().map(Role::getRoleCode).distinct().collect(Collectors.toList());
        authorizationInfo.addRoles(roleCodes);

        List<Permission> permissions = loginService.getUserPermissions(roles);
        List<String> stringList = permissions.stream().map(Permission::getPermission).distinct().collect(Collectors.toList());
        authorizationInfo.addStringPermissions(stringList);

        return authorizationInfo;
    }

    /**
     * 定义如何获取用户信息的业务逻辑，给shiro做登录
     *
     * @param authenticationToken
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        log.info("登录认证");

        String username = (String) authenticationToken.getPrincipal();
        Object password = authenticationToken.getCredentials();

        User user = loginService.getUserByName(username);

        System.out.println(passwordService.encryptPassword(password));

        if (user == null) {
            throw new UnknownAccountException();
        }

        if (1 == user.getStatus()) {
            throw new LockedAccountException();
        }

        //交给AuthenticatingRealm使用CredentialsMatcher进行密码匹配，如果觉得人家的不好可以在此判断或自定义实现
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(user.getUsername(), user.getPassword(), getName());
        authenticationInfo.setCredentialsSalt(ByteSource.Util.bytes(SALT));
        return authenticationInfo;
    }
}
