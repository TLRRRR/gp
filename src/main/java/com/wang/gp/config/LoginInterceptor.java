package com.wang.gp.config;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Object loginUser = request.getSession().getAttribute("LoginUser");
        System.out.println("走这里了吗");
        if(loginUser==null){
            System.out.println("loginuser为空，登录失败了？？？");
            response.sendRedirect("/tologin");
            return false;
        }else {
            return true;
        }
    }

}
