package com.ben.simpleshiro;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.realm.text.IniRealm;
import org.apache.shiro.subject.Subject;
import org.junit.Test;

import java.util.Arrays;

/**
 * @author yangkun
 */
public class IniRealmTest {

    @Test
    public void testAuthentication() {

        IniRealm iniRealm = new IniRealm("classpath:user.ini");

        DefaultSecurityManager securityManager = new DefaultSecurityManager();
        securityManager.setRealm(iniRealm);

        SecurityUtils.setSecurityManager(securityManager);
        Subject subject = SecurityUtils.getSubject();

        AuthenticationToken token = new UsernamePasswordToken("admin", "123456");

        subject.login(token);
        System.out.println(subject.isAuthenticated());
        System.out.println(Arrays.toString(subject.hasRoles(Arrays.asList("admin", "role1"))));
        System.out.println(Arrays.toString(subject.isPermitted("user:delete", "user:add")));
        subject.logout();
        System.out.println(subject.isAuthenticated());
    }
}
