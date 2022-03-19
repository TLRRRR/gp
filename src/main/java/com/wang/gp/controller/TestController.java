package com.wang.gp.controller;

import com.wang.gp.pojo.Login;
import com.wang.gp.pojo.User;
import com.wang.gp.service.LoginService;
import com.wang.gp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

@Controller
public class TestController {

    @Autowired
    LoginService loginService;

    @Autowired
    UserService userService;

    @GetMapping("/t")
    public void t(String name, HttpServletResponse response) throws IOException {
        if ("fu".equals(name)) {
            response.getWriter().print("success");
        } else {
            response.getWriter().print("fail");
        }
    }

    @RequestMapping("/t2")
    @ResponseBody
    public String test2(){
        Login queryUser = loginService.queryUser("hhhhh");
        System.out.println(queryUser);
        return queryUser.toString();
    }

    @RequestMapping("/t3")
    @ResponseBody
    public String test3(){
        Date date = new Date();
        System.out.println(date);
        int insertUser = loginService.insertUser("jerry", date, 1);
        System.out.println(insertUser);
        return "insertUser";
    }

    @RequestMapping("/t4")
    @ResponseBody
    public String test4(){
        User selectUserById = userService.selectUserById(1);
        System.out.println(selectUserById);
//        return "queryUser";
        return "why babe why";
    }

    @RequestMapping("/t5")
    @ResponseBody
    public String test5(){
        return "why babe why";
    }

    @RequestMapping("/t6")
    @ResponseBody
    public String test6(){
        Date date = new Date();
        System.out.println(date);
        int updateUser = loginService.updateUser("xxxxx", date, 2);
        System.out.println(updateUser);
        return "updateUser";
    }
}
