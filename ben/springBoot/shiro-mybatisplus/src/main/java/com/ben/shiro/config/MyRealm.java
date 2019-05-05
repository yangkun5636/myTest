package com.ben.shiro.config;

import com.ben.shiro.pojo.bo.SysPermission;
import com.ben.shiro.pojo.bo.SysRole;
import com.ben.shiro.pojo.bo.SysUser;
import com.ben.shiro.service.LoginService;
import com.ben.shiro.util.Constants;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authc.*;
import org.apache.shiro.authc.credential.PasswordService;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
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

    private static final String SALT = "salt";

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
        SysUser sysUser = loginService.getUserByName(username);

        List<SysRole> roles = loginService.getUserRole(sysUser.getId());

        List<String> roleCodes = roles.stream().map(SysRole::getRoleCode).distinct().collect(Collectors.toList());
        authorizationInfo.addRoles(roleCodes);
        List<SysPermission> permissions = loginService.getPermissionList(roleCodes);
        for (SysPermission p : permissions) {
            authorizationInfo.addStringPermission(p.getPermission());
        }
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
        redisTemplate.opsForValue().set("aa", "aaa");
        System.out.println(redisTemplate.opsForValue().get("aa"));
        String username = (String) authenticationToken.getPrincipal();
        Object password = authenticationToken.getCredentials();
        SysUser sysUser = loginService.getUserByName(username);
        System.out.println(passwordService.encryptPassword(password));
        if (sysUser == null) {
            throw new UnknownAccountException();
        }

        if (Constants.USER_STATUS_1.equals(sysUser.getStatus())) {
            throw new LockedAccountException();
        }

        //交给AuthenticatingRealm使用CredentialsMatcher进行密码匹配，如果觉得人家的不好可以在此判断或自定义实现
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(sysUser.getUsername(), sysUser.getPassword(), getName());

        return authenticationInfo;
    }
}
