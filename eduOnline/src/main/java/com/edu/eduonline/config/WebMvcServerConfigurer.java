package com.edu.eduonline.config;

import com.edu.eduonline.pojo.User;
import org.apache.shiro.SecurityUtils;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Author: 梁其定
 * @DateTime: 2020/3/13 0013 14:46
 * @Description: TODO
 */
@Configuration
public class WebMvcServerConfigurer implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        InterceptorRegistration interceptor = registry.addInterceptor(new SessionInterceptor());
        /**
         * 添加拦截的路径
         * /为根路径
         * /*为一级路径
         * /** 为所有路径包括多级
         */
        interceptor.addPathPatterns("/**");
        //排除不拦截的，包括自己登录的页面不用拦截
        /**
         * @Author 梁其定
         * @Description //TODO 放行静态资源
         * @Date 15:02 2020/3/13 0013
         * @Param
         * @return
        **/

        interceptor.excludePathPatterns("/images/**");
        interceptor.excludePathPatterns("/static/**");
        interceptor.excludePathPatterns("/js/**");
        interceptor.excludePathPatterns("/login/**");
        interceptor.excludePathPatterns("/main/**");
        interceptor.excludePathPatterns("/video/**");
        interceptor.excludePathPatterns("/vuejs/**");

        /**
         * @Author 梁其定
         * @Description //TODO 常用链接放行
         * @Date 15:03 2020/3/13 0013
         * @Param
         * @return
        **/
        interceptor.excludePathPatterns("/login");
        interceptor.excludePathPatterns("/index");
        interceptor.excludePathPatterns("/main/**");
        interceptor.excludePathPatterns("/dologin");
        interceptor.excludePathPatterns("/register");
        interceptor.excludePathPatterns("/doregister");
        interceptor.excludePathPatterns("/GetCourse");

    }
}
