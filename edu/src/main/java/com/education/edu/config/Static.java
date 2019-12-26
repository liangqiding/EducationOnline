package com.education.edu.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author 梁其定
 * @version 1.0
 * @date 2019/12/11/011 16:42
 * @descriptio
 */
@Configuration
    public class Static implements WebMvcConfigurer {
        @Override
        public void addResourceHandlers(ResourceHandlerRegistry registry) {
            //映射图片保存地址
//获取项目路径
            String property = System.getProperty("user.dir");
            System.out.println(property);
            String [] s=property.split("\\\\");
            StringBuffer stringBuffer=new StringBuffer();
            for (String x:s){
                stringBuffer.append(x+"\\\\");
            }
            registry.addResourceHandler("/images/**").addResourceLocations("file:"+stringBuffer.toString()+"src\\main\\resources\\static\\images\\");
            registry.addResourceHandler("/video/**").addResourceLocations("file:"+stringBuffer.toString()+"src\\main\\resources\\static\\video\\");
        }
    }

