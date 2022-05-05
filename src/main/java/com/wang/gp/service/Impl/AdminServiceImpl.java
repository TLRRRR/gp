package com.wang.gp.service.Impl;

import com.wang.gp.dao.AdminDao;
import com.wang.gp.dao.LoginDao;
import com.wang.gp.pojo.Admin;
import com.wang.gp.pojo.Login;
import com.wang.gp.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    AdminDao adminDao;

    @Autowired
    LoginDao loginDao;

    //登录
    @Override
    public Admin confirmAdmin(String adname, String pwd) {
        return adminDao.confirmAdmin(adname, pwd);
    }

    //登录验证
    public String adminLogin(String adname, String pwd) {
        //查询该管理员
        Admin admin = adminDao.confirmAdmin(adname, pwd);
        //查询该昵称
        Admin admin1 = adminDao.confirmAdminAdname(adname);
        //错误登录记录
        Login login = loginDao.queryUser(adname);

        Date errorLoginTime = new Date();
        if (login == null) {
            loginDao.insertUser(adname, errorLoginTime, 0);
            //login表和user表没有设置关联，如果user表中存在该用户而login表中不存在，则将其添加进去。
            login = loginDao.queryUser(adname);
        }

        int count = login.getCount();
        System.out.println("count: " + count);
        Date time = login.getTime();
        long result = errorLoginTime.getTime() - time.getTime();

        if (result > 180000)
            count = 0;

        if (admin1 != null) {      //数据库里存在昵称为userName的用户
            System.out.println("用户id存在");
            if (count > 2)//连续错误登陆次数已经超过三次
            {
                System.out.println("登录错误次数太多，账户锁定");
//                String jsonStr = "{\"errorCode\":\"33\",\"errorMessage\":\"您由于错误登陆次数太多，系统已将您的账户锁定，请在三分钟后重新登录！\"}";
                String jsonStr = "33";
                loginDao.updateUser(adname, errorLoginTime, count + 1);
                return jsonStr;
            } else {
                //id存在，密码错误
                if ((admin == null)) {        //用户存在但密码输入错误，那么输出密码输入错误，并且如果当前和上次错误时间相隔不到1分钟则count+1;
                    System.out.println("id存在，密码错误");
//                    String jsonStr = "{\"errorCode\":\"22\",\"errorMessage\":\"密码输入错误，错误输入三次后您的账户将会被锁定！\"}";
                    String jsonStr = "22";
                    loginDao.updateUser(adname, errorLoginTime, count + 1);
                    return jsonStr;
                } else {
                    System.out.println("登录成功");
                    loginDao.updateUser(adname, errorLoginTime, 0);
//                    HttpSession session = request.getSession();
//                    session.setAttribute("LoginUser", np_user);
//                    System.out.println(request.getSession());
//                    String jsonStr = "{\"errorCode\":\"00\",\"errorMessage\":\"登陆成功！\"}";
//                    return jsonStr;
                    String success = "success";
                    return success;
                }
            }
        } else {    //该数据库没有存储过该tel
            System.out.println("用户id不存在");
            System.out.println(errorLoginTime);
            loginDao.updateUser(adname, errorLoginTime, count + 1);
//            String jsonStr = "{\"errorCode\":\"11\",\"errorMessage\":\"该用户不存在\"}";
            String jsonStr = "11";
            return jsonStr;
        }
    }

    //注册
    @Override
    public String registerAdmin(String adname, String pwd) {
        System.out.println("impl");
        Admin admin = adminDao.confirmAdminAdname(adname);
        System.out.println(admin);
        if (admin != null) {
            return "11";
        } else {
            System.out.println("then else");
            adminDao.registerAdmin(adname, pwd);
            return "22";
        }
    }

//    @Override
//    public Admin confirmAdminAdname(String adname) {
//        return ;
//    }
}
