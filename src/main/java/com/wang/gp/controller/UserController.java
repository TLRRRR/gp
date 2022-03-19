package com.wang.gp.controller;

import com.wang.gp.pojo.Login;
import com.wang.gp.pojo.User;
import com.wang.gp.service.LoginService;
import com.wang.gp.service.UserService;
import com.wang.gp.utils.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private LoginService loginService;

    //注册页面
    @GetMapping("/toregister")
    public String toRegist() {
        return "register";
    }

    //登录页面
    @GetMapping("/tologin")
    public String toLogin() {
        return "index";
    }

    //密码找回
    @GetMapping("/tofindback")
    public String toFindBack() {
        return "findback";
    }

    //密码找回2
    @GetMapping("/tofindback2")
    public String toFindBack2() {
        return "findback2";
    }

    //内容页面
    @GetMapping("/content")
    public String toContent() {
        return "content";
    }

    //注册验证
    @ResponseBody
    @PostMapping("/register")
    public String register(String userName, String pwd, String tel) {
        User user = new User();
        user.setUserName(userName);
        user.setPwd(MD5Utils.getMD5(pwd));
        user.setTel(tel);
        return userService.register(user);

//        //查询用户表中是否存在此用户
//        User t_user = userService.registerQueryUser(userName);
//
//        if (t_user == null) {
//            //用户表中不存在此用户，注册成功
//            userService.registerUser(userName, pwd, tel);
//            return "redirect:/tologin";
//        } else {
//            //注册失败
//            return "de";
//        }
    }

    //登录验证
    @ResponseBody
    @PostMapping("/login")
    public String login(@RequestParam(value = "userName") String userName, @RequestParam(value = "pwd") String pwd,
                        HttpServletRequest request) {
        User user = new User();
        user.setUserName(userName);
        user.setPwd(MD5Utils.getMD5(pwd));
        String login = userService.login(user);
        if (login == "success") {
            request.getSession().setAttribute("LoginUser", user);
            System.out.println("用户的session是："+request.getSession());
            String jsonStr = "{\"errorCode\":\"00\",\"errorMessage\":\"登陆成功！\"}";
            return jsonStr;
        } else {
            return login;
        }
    }

    //找回密码
    @ResponseBody
    @PostMapping("/findback")
    public String findBack(String tel, String pwd, String pwd2) {
        User user = userService.queryUserByTel(tel);
        return userService.findback(user);
    }

    //找回密码2
    @ResponseBody
    @PostMapping("/findback2")
    public String findBack2(String userName, String pwd, String pwd2) {

        if (pwd == pwd2) {
            return "{\"errorCode\":\"00\",\"errorMessage\":\"密码重置成功\"}";
        } else {
            return "{\"errorCode\":\"11\",\"errorMessage\":\"密码重置失败\"}";
        }
    }

    //登录验证
//    @ResponseBody
//    @PostMapping("/login")
//    public String login(@RequestParam(value = "userName")String userName,@RequestParam(value = "pwd")String pwd){
//        pwd = MD5Utils.getMD5(pwd);
//        User user = new User();
//        user.setUserName(userName);
//        user.setPwd(pwd);
//
//        User t_user = userService.registerQueryUser(userName);
//        if(t_user==null){
//            //登录失败
//            return "de";
//        }else {
//            //登录成功
//            return "redirect:/content";
//        }
//    }

    //登陆验证
//    @PostMapping("/login")
//    @ResponseBody
//    public String login(@RequestParam(value = "userName") String userName, @RequestParam(value = "pwd") String pwd,
//                        HttpServletRequest request) {
//
//        User user = new User();
//        user.setUserName(userName);
//        pwd = MD5Utils.getMD5(pwd);
//        user.setPwd(pwd);
//        System.out.println(userName);
//        //判断用户是否在数据库里，如果User不为空，则账号密码在数据库中有相应的匹配，即用户存在
//        User rs_user = userService.queryUser(user);
//        //判断用户是否在user数据库里
//        User t = userService.registerQueryUser(userName);
//        //判断表login中是否已经有这个账户
//        Login rs_login = loginService.queryUser(userName);
//        System.out.println(rs_login);
//
//        Date errorLoginTime = new Date();
//        if (rs_login == null) {
//            loginService.insertUser(userName, errorLoginTime, 0);
//            //login表和user表没有设置关联，如果user表中存在该用户而login表中不存在，则将其添加进去。
//            rs_login = loginService.queryUser(userName);
//        }
//        int count = rs_login.getCount();
//        System.out.println("count: " + count);
//        Date time = rs_login.getTime();
//        long result = errorLoginTime.getTime() - time.getTime();
//
//        if (result > 180000)
//            count = 0;
//
//        if (t != null) {      //数据库里存在昵称为userName的用户
//            System.out.println("用户id存在");
//            if (count > 2)//连续错误登陆次数已经超过三次
//            {
//                System.out.println("登录错误次数太多，账户锁定");
//                String jsonStr = "{\"errorCode\":\"33\",\"errorMessage\":\"您由于错误登陆次数太多，系统已将您的账户锁定，请在三分钟后重新登录！\"}";
//                loginService.updateUser(userName, errorLoginTime, count + 1);
//                return jsonStr;
//            } else {
//                //id存在，密码错误
//                System.out.println("id存在，密码错误");
//                if ((null == rs_user)) {        //用户存在但密码输入错误，那么输出密码输入错误，并且如果当前和上次错误时间相隔不到1分钟则count+1;
//                    String jsonStr = "{\"errorCode\":\"22\",\"errorMessage\":\"密码输入错误，错误输入三次后您的账户将会被锁定！\"}";
//                    loginService.updateUser(userName, errorLoginTime, count + 1);
//                    return jsonStr;
//                } else {
//                    System.out.println("登录成功");
//                    loginService.updateUser(userName, errorLoginTime, 0);
//                    HttpSession session = request.getSession();
//                    session.setAttribute("rs_user", rs_user);
//                    System.out.println(request.getSession());
//                    String jsonStr = "{\"errorCode\":\"00\",\"errorMessage\":\"登陆成功！\"}";
//                    return jsonStr;
//                }
//            }
//        } else {    //该数据库没有存储过该tel
//            System.out.println("用户id不存在");
//            System.out.println(userName);
//            System.out.println(errorLoginTime);
//            loginService.updateUser(userName, errorLoginTime, count + 1);
//            String jsonStr = "{\"errorCode\":\"11\",\"errorMessage\":\"该用户不存在\"}";
//            return jsonStr;
//        }
//
//    }

}
