/**
 * 后台系统身份验证拦截器定义
 */
package com.example.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * 后台系统身份验证拦截器配置
 */
/*
@Configuration
public class MyWebMvcConfigurer implements WebMvcConfigurer {
    @Autowired
    private AdminLoginInterceptor adminLoginInterceptor;
    public void addInterceptors(InterceptorRegistry registry) {
// 添加一个拦截器，拦截以/admin为前缀的所有路径，排除/admin/userlogin
        registry.addInterceptor(adminLoginInterceptor).addPathPatterns("/admin/**").excludePathPatterns("/admin/userlogin","/admin/signup","admin/success","/admin/admin/register");
    }
}
*/




