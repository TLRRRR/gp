package com.wang.gp.controller;

import com.wang.gp.pojo.Login;
import com.wang.gp.pojo.User;
import com.wang.gp.service.LoginService;
import com.wang.gp.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

public class usertest {

    @Autowired
    LoginService loginService;

    @Autowired
    UserService userService;

    @Test
    public void t(){
        Login login = new Login();
        Date date = new Date();
        System.out.println(date);
//        loginService.insertUser("aaa",date,0);
//        Login login1 = loginService.queryUser("aaa");
//        Login login2 = loginService.queryUser("ttt");
//        User user = userService.queryUser("111","111");
//        User user = userService.registerQueryUser("111");
//        System.out.println(user);

//        System.out.println("login2"+login2);
//        System.out.println(login1);
    }
}
