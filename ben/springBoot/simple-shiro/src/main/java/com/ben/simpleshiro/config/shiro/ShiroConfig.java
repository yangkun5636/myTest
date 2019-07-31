package com.ben.simpleshiro.config.shiro;

import com.ben.simpleshiro.config.permission.MyPermissionFilter;
import org.apache.shiro.authc.credential.CredentialsMatcher;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.spring.web.config.DefaultShiroFilterChainDefinition;
import org.apache.shiro.spring.web.config.ShiroFilterChainDefinition;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.StringRedisTemplate;

import javax.servlet.Filter;
import java.util.HashMap;
import java.util.Map;

/**
 * @author yangkun
 */
@Configuration
public class ShiroConfig {

    @Bean
    public Realm realm(StringRedisTemplate redisTemplate) {
        MyRealm myRealm = new MyRealm();
        RetryCredentialMatcher retryCredentialMatcher = new RetryCredentialMatcher();
        retryCredentialMatcher.setRedisTemplate(redisTemplate);
        myRealm.setCredentialsMatcher(retryCredentialMatcher);
        return myRealm;
    }

    @Bean
    public MyAuthorizationFilter myAuthorizationFilter() {
        return new MyAuthorizationFilter();
    }

    @Bean
    public MyAccessControlFilter myAccessControlFilter() {
        return new MyAccessControlFilter();
    }

    @Bean
    public MyPermissionFilter myPermissionFilter() {
        return new MyPermissionFilter();
    }

    @Bean("shiroFilterFactoryBean")
    public ShiroFilterFactoryBean filterFactoryBean(SecurityManager securityManager) {
        ShiroFilterFactoryBean bean = new ShiroFilterFactoryBean();
        bean.setSecurityManager(securityManager);
        Map<String, Filter> filterMap = new HashMap<>();
//        filterMap.put("myPerm", myPermissionFilter());
//        filterMap.put("myAcce", myAccessControlFilter());
        filterMap.put("myAuth", myAuthorizationFilter());
        bean.setFilters(filterMap);
        bean.setFilterChainDefinitionMap(shiroFilterChainDefinition().getFilterChainMap());
        return bean;
    }

//    @Bean
//    public RedisSessionDao getRedisSessionDao() {
//        return new RedisSessionDao();
//    }

//    @Bean(name="securityManager")
//    public DefaultWebSecurityManager securityManager() {
//        DefaultWebSecurityManager manager = new DefaultWebSecurityManager();
//        manager.setRealm(realm());
//        manager.setSessionManager(defaultWebSessionManager());
//        return manager;
//    }


    /**
     * @return
     * @see DefaultWebSessionManager
     */
//    @Bean(name = "sessionManager")
//    public DefaultWebSessionManager defaultWebSessionManager() {
//        DefaultWebSessionManager sessionManager = new DefaultWebSessionManager();
//        //sessionManager.setCacheManager(cacheManager());
//        sessionManager.setGlobalSessionTimeout(43200000); //12小时
//        sessionManager.setDeleteInvalidSessions(true);
//        //关键在这里
//        sessionManager.setSessionDAO(getRedisSessionDao());
//        sessionManager.setSessionValidationSchedulerEnabled(true);
//        sessionManager.setDeleteInvalidSessions(true);
//        return sessionManager;
//    }

    /**
     * 过滤器：
     * anon	                org.apache.shiro.web.filter.authc.AnonymousFilter
     * authc	            org.apache.shiro.web.filter.authc.FormAuthenticationFilter
     * authcBasic	        org.apache.shiro.web.filter.authc.BasicHttpAuthenticationFilter
     * logout	            org.apache.shiro.web.filter.authc.LogoutFilter
     * noSessionCreation	org.apache.shiro.web.filter.session.NoSessionCreationFilter
     * perms	            org.apache.shiro.web.filter.authz.PermissionsAuthorizationFilter
     * port	                org.apache.shiro.web.filter.authz.PortFilter
     * rest	                org.apache.shiro.web.filter.authz.HttpMethodPermissionFilter
     * roles	            org.apache.shiro.web.filter.authz.RolesAuthorizationFilter
     * ssl  	            org.apache.shiro.web.filter.authz.SslFilter
     * user	                org.apache.shiro.web.filter.authc.UserFilter
     */
    @Bean
    public ShiroFilterChainDefinition shiroFilterChainDefinition() {
        DefaultShiroFilterChainDefinition chain = new DefaultShiroFilterChainDefinition();

        chain.addPathDefinition("/login", "anon");
        chain.addPathDefinition("/anon/*", "anon");

        chain.addPathDefinition("/**", "myAuth,authc");
        return chain;
    }


    @Bean
    public static DefaultAdvisorAutoProxyCreator getDefaultAdvisorAutoProxyCreator() {
        DefaultAdvisorAutoProxyCreator creator = new DefaultAdvisorAutoProxyCreator();
        /**
         * setUsePrefix(false)用于解决一个奇怪的bug。在引入spring aop的情况下。
         * 在@Controller注解的类的方法中加入@RequiresRole注解，会导致该方法无法映射请求，导致返回404。
         * 加入这项配置能解决这个bug
         */
        creator.setUsePrefix(true);

        return creator;
    }

}