package com.ben.simpleshiro;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.realm.jdbc.JdbcRealm;
import org.apache.shiro.subject.Subject;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

/**
 * @author yangkun
 */
public class JdbcRealmTest {
    DruidDataSource dataSource = new DruidDataSource();

    @Before
    public void setDataSource() {
        dataSource.setUrl("jdbc:mysql://127.0.0.1:3307/ben?autoReconnect=true&useUnicode=true&characterEncoding=utf-8&serverTimezone=GMT%2B8");
        dataSource.setName("root");
        dataSource.setUsername("root");
        dataSource.setPassword("123456");
    }

    @Test
    public void testAuthentication() {

        //    protected String authenticationQuery = "select password from users where username = ?";
        //    protected String userRolesQuery = "select role_name from user_roles where username = ?";
        //    protected String permissionsQuery = "select permission from roles_permissions where role_name = ?";
        JdbcRealm jdbcRealm = new JdbcRealm();
        jdbcRealm.setDataSource(dataSource);
        jdbcRealm.setAuthenticationQuery("select password from s_sys_user where username=?");
        jdbcRealm.setPermissionsLookupEnabled(true);
        //admin
        //guest
        //guest
        jdbcRealm.setUserRolesQuery("SELECT a.role_code FROM s_sys_role a LEFT JOIN s_sys_user_role b ON a.id =b.role_id LEFT JOIN s_sys_user c ON b.user_id=c.id WHERE c.username=?");
        //dataDict:list
        jdbcRealm.setPermissionsQuery("SELECT a.permission_code FROM s_sys_permission a LEFT JOIN s_sys_role_permission b ON a.id = b.permission_id LEFT JOIN s_sys_role c ON c.id = b.role_id WHERE c.role_code=?");

        DefaultSecurityManager securityManager = new DefaultSecurityManager();
        securityManager.setRealm(jdbcRealm);

        SecurityUtils.setSecurityManager(securityManager);
        Subject subject = SecurityUtils.getSubject();

        AuthenticationToken token = new UsernamePasswordToken("admin", "123456");

        subject.login(token);
        System.out.println("是否登录:" + subject.isAuthenticated());
        System.out.println("角色:"+Arrays.toString(subject.hasRoles(Arrays.asList("admin"))));

        System.out.println("权限:"+Arrays.toString(subject.isPermitted("user:delete", "user:add","dataDict:list")));
        subject.logout();
        System.out.println("是否登录:" + subject.isAuthenticated());
    }
}
