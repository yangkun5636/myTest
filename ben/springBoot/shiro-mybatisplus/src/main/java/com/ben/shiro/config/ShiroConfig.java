package com.ben.shiro.config;

import org.apache.shiro.authc.credential.DefaultPasswordService;
import org.apache.shiro.authc.credential.PasswordService;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.spring.web.config.DefaultShiroFilterChainDefinition;
import org.apache.shiro.spring.web.config.ShiroFilterChainDefinition;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;
import java.util.HashMap;
import java.util.Map;

/**
 * @author yangkun
 */
@Configuration
public class ShiroConfig {

    /**
     * 注入自定义的realm，告诉shiro如何获取用户信息来做登录认证和授权
     */
    @Bean
    public Realm realm() {
        return new MyRealm();
    }

    @Bean
    public ShiroFilterFactoryBean filterFactoryBean(SecurityManager securityManager) {
        ShiroFilterFactoryBean bean = new ShiroFilterFactoryBean();
        bean.setSecurityManager(securityManager);
        Map<String, Filter> filterMap = new HashMap<>();
        filterMap.put("myPerm", new MyPermissionFilter());
        bean.setFilters(filterMap);
        bean.setFilterChainDefinitionMap(shiroFilterChainDefinition().getFilterChainMap());
        return bean;
    }

    /**
     * 这里统一做鉴权，即判断哪些请求路径需要用户登录，哪些请求路径不需要用户登录。
     * 这里只做鉴权，不做权限控制，因为权限用注解来做。
     */
    @Bean
    public ShiroFilterChainDefinition shiroFilterChainDefinition() {
        DefaultShiroFilterChainDefinition chain = new DefaultShiroFilterChainDefinition();
        // 设置哪些请求可以匿名访问
        chain.addPathDefinition("/login", "anon");

        // 由于使用Swagger调试，因此设置所有Swagger相关的请求可以匿名访问
        chain.addPathDefinition("/swagger-ui.html", "anon");
        chain.addPathDefinition("/webjars/springfox-swagger-ui/**", "anon");
        chain.addPathDefinition("/swagger-resources", "anon");
        chain.addPathDefinition("/swagger-resources/configuration/security", "anon");
        chain.addPathDefinition("/swagger-resources/configuration/ui", "anon");
        chain.addPathDefinition("/v2/api-docs", "anon");
        chain.addPathDefinition("/data-dict/**", "myPerm");
        chain.addPathDefinition("/dataItem/**", "myPerm");

        //除了以上的请求外，其它请求都需要登录
        chain.addPathDefinition("/**", "authc");
        return chain;
    }

    @Bean
    public DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator() {
        DefaultAdvisorAutoProxyCreator creator = new DefaultAdvisorAutoProxyCreator();
        creator.setUsePrefix(true);
        return creator;
    }

    @Bean
    public PasswordService passwordService() {
        return new DefaultPasswordService();
    }

}


