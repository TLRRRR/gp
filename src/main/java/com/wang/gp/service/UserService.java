package com.wang.gp.service;

import com.wang.gp.pojo.User;

public interface UserService {

    public User selectUserById(int userId);

    public User queryUser(User user);

    public User registerQueryUser(String userName);

    public User queryUserByTel(String tel);

    public int registerUser(String userName,String pwd,String tel);

    public int updatePwd(String userName, String pwd, String tel);


    //登录
    public String login(User user);

    //注册
    public String register(User user);

    //密码找回
    public String findback(User user);

}
