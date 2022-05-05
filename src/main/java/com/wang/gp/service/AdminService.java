package com.wang.gp.service;

import com.wang.gp.pojo.Admin;

public interface AdminService {

    //查询管理员昵称、密码是否正确
    public Admin confirmAdmin(String adname, String pwd);

    //逻辑判断
    public String adminLogin(String adname, String pwd);

    //注册管理员
    public String registerAdmin(String adname, String pwd);

//    //查询该管理员昵称是否存在
//    public Admin confirmAdminAdname(String adname);
}
