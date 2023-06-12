package com.example.util;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 后台系统身份验证拦截器定义
 *//*

@Component
public class AdminLoginInterceptor implements HandlerInterceptor {

    //调用Controller方法前执行。当其返回值为true时，继续向下执行；当其返回值为false时，会中断后续的所有操作。
*/
/*    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {
        String requestServletPath = request.getServletPath();
        if (requestServletPath.startsWith("/admin") && null == request.getSession().getAttribute("name")) {
            request.getSession().setAttribute("errorMsg", "请重新登陆");
            response.sendRedirect(request.getContextPath() + "/admin/userlogin");
            return false;
        } else {
            request.getSession().removeAttribute("errorMsg");
            return true;
        }
    }*//*


    //调用Controller方法调用之后，且解析视图之前执行。可以通过此方法对请求域中的模型和视图做出进一步的修改。
    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
    }

    //在整个请求完成，即视图渲染结束之后执行。可以通过此方法实现一些资源清理、记录日志信息等工作。
    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
*/
@Component
public class AdminLoginInterceptor implements HandlerInterceptor {
    //调用Controller方法前执行。当其返回值为true时，继续向下执行；当其返回值为false时，会中断后续的所有操作。
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse
            response, Object o) throws Exception {
        String requestServletPath = request.getServletPath();
        if (requestServletPath.startsWith("/admin") &&
                null == request.getSession().getAttribute("name")) {
            request.getSession().setAttribute("errorMsg", "请重新登陆");
            response.sendRedirect(request.getContextPath() +
                    "/admin/userlogin");
            return false;
        } else {
            request.getSession().removeAttribute("errorMsg");
            return true;
        }
    }

    //调用Controller方法调用之后，且解析视图之前执行。可以通过此方法对请求域中的模型和视图做出进一步的修改。
    @Override
    public void postHandle(HttpServletRequest httpServletRequest,
                           HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView)
            throws Exception {
    }
    //在整个请求完成，即视图渲染结束之后执行。可以通过此方法实现一些资源清理、记录日志信息等工作。
    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest,
                                HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception
    {
    }
}