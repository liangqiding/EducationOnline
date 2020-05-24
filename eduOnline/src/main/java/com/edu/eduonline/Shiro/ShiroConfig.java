package com.edu.eduonline.Shiro;

import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.authz.Authorizer;
import org.apache.shiro.authz.ModularRealmAuthorizer;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author 梁其定
 * @version 1.0
 * @date 2019/12/12/012 20:58
 * @descriptio Shiro配置类
 */
@Configuration
public class ShiroConfig {


        @Bean(name = "shiroFilter")
        public ShiroFilterFactoryBean shiroFilter (@Qualifier("securityManage") DefaultWebSecurityManager
        defaultWebSecurityManager){
            ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
//        1设置安全管理器
            shiroFilterFactoryBean.setSecurityManager(defaultWebSecurityManager);
            /*
             * Shiro 的内置过滤器
             * anon：无须认证
             * authc:必须认证
             * authcBasic：Basic HTTP身份验证拦截器，主要属性： applicationName：弹出登录框显示的信息（application）；
             * user:用户拦截器，用户已经身份验证/记住我登录的都可；示例“/**=user”
             * logout：退出拦截器，主要属性：redirectUrl：退出成功后重定向的地址（/）
             * anon：匿名拦截器，即不需要登录即可访问；一般用于静态资源过滤；示例“/static/**=anon”
             */
            Map<String, String> filterMap = new LinkedHashMap<String, String>();
            System.out.println("shiro");
            filterMap.put("/manage","perms[user:admin]");
            filterMap.put("/managetable","perms[user:admin]");

//           filterMap.put("/css/**","anon");
//           filterMap.put("/fonts/**","anon");
//           filterMap.put("/img/**","anon");
//           filterMap.put("/js/**","anon");
//           filterMap.put("/login/**","anon");
//           filterMap.put("/vuejs/**","anon");
//           filterMap.put("/admin/**","anon");
//           filterMap.put("/images/**","anon");
//           filterMap.put("/main/**","anon");
//           filterMap.put("/login","anon");
//
//           filterMap.put("/","anon");
//           filterMap.put("/index","anon");
//           filterMap.put("/dologin","anon");
//           filterMap.put("/register","anon");
//           filterMap.put("/doregister","anon");
////           放行首页获取课程列表
//           filterMap.put("/GetCourse","anon");
//           filterMap.put("/**","authc");
//           filterMap.put("/vip","authc");
//           授权逻辑

            shiroFilterFactoryBean.setLoginUrl("/login");

            shiroFilterFactoryBean.setFilterChainDefinitionMap(filterMap);
//            权限认证
            shiroFilterFactoryBean.setUnauthorizedUrl("/");
            return shiroFilterFactoryBean;
        }

        @Bean(name = "securityManage")
        public DefaultWebSecurityManager getDefaultWebSecurityManager (@Qualifier("userRealm") UserRealm userRealm){
            DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
//    关联Realm
            securityManager.setRealm(userRealm);
            return securityManager;
        }

        @Bean(name = "userRealm")
        public UserRealm getUserRealm (HashedCredentialsMatcher hashedCredentialsMatcher) {
            UserRealm userRealm=new UserRealm();
            //设置加密方式
            userRealm.setCredentialsMatcher(hashedCredentialsMatcher);
            return userRealm;
        }

    @Bean
    public HashedCredentialsMatcher hashedCredentialsMatcher(){
        HashedCredentialsMatcher credentialsMatcher = new HashedCredentialsMatcher();
        //指定加密方式
        credentialsMatcher.setHashAlgorithmName("MD5");
        System.out.println("加密方式：MD5");
        //加密次数
        credentialsMatcher.setHashIterations(2);
        //此处的设置，true加密用的hex编码，false用的base64编码
        credentialsMatcher.setStoredCredentialsHexEncoded(true);
        return credentialsMatcher;
    }
    }
