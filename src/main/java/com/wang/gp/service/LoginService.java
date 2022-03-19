package com.wang.gp.service;

import com.wang.gp.pojo.Login;

import java.util.Date;

public interface LoginService {
    //查询错误登录
    public Login queryUser(String userName);
    //添加错误登录
    public int insertUser(String userName, Date errorLoginTime, int count);
    //更新错误登录
    public int updateUser(String userName, Date errorLoginTime, int count);
}
