package com.wang.gp.controller;

import com.wang.gp.pojo.Login;
import com.wang.gp.pojo.User;
import com.wang.gp.service.LoginService;
import com.wang.gp.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

public class logintest {
    @Autowired
    LoginService loginService;
    @Autowired
    UserService userService;

    @Test
    public void test(){
        Login queryUser = loginService.queryUser("hhhhh");
        System.out.println(queryUser);
//        Date date = new Date();
//        System.out.println(date);
//        int insertUser = loginService.insertUser("jerry", date, 1);
//        int updateUser = loginService.updateUser("xxxxx", date, 2);
    }

    @Test
    public void test1(){
//        Login queryUser = loginService.queryUser("hhhhh");
        Date date = new Date();
        System.out.println(date);
        int insertUser = loginService.insertUser("jerry", date, 1);
        System.out.println(insertUser);
//        int updateUser = loginService.updateUser("xxxxx", date, 2);
    }

    @Test
    public void test2(){
//        Login queryUser = loginService.queryUser("hhhhh");
        Date date = new Date();
        System.out.println(date);
//        int insertUser = loginService.insertUser("jerry", date, 1);
        int updateUser = loginService.updateUser("xxxxx", date, 2);
        System.out.println(updateUser);
    }

    @Test
    public void test3(){
        User selectUserById = userService.selectUserById(1);
        System.out.println(selectUserById);
    }
}
