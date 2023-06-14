/*
package com.example.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

*/
/**
 * 后台系统身份验证拦截器配置
 *//*

@Configuration
public class MyWebMvcConfigurerbackup implements WebMvcConfigurer {

    @Autowired
    private AdminLoginInterceptor adminLoginInterceptor;

    public void addInterceptors(InterceptorRegistry registry) {
        // 添加一个拦截器，拦截以/admin为前缀的所有路径，排除/admin/userlogin
        registry.addInterceptor(adminLoginInterceptor).addPathPatterns("/admin/**").excludePathPatterns("/admin/userlogin");
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/upload/**").addResourceLocations("classpath:/upload/","file:upload/");
//当访问路径是addResourceHandler中的路径时，映射到访问addResourceLocations中的本地路径
//classpath:/ 项目打包为jar文件后，jar包根目录
//file: Maven项目的目录下（与pom.xml同目录）；项目打包后jar包根目录}
}}
*/
