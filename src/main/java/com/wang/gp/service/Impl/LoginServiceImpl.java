package com.wang.gp.service.Impl;

import com.wang.gp.dao.LoginDao;
import com.wang.gp.pojo.Login;
import com.wang.gp.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    LoginDao loginDao;

    //查询错误登录
    @Override
    public Login queryUser(String userName) {
        return loginDao.queryUser(userName);
    }

    //添加错误登录
    @Override
    public int insertUser(String userName, Date errorLoginTime, int count) {
        return loginDao.insertUser(userName,errorLoginTime,count);
    }

    //更新错误登录
    @Override
    public int updateUser(String userName, Date errorLoginTime, int count) {
        return loginDao.updateUser(userName,errorLoginTime,count);
    }
}
