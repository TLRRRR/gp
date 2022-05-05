package com.wang.gp.dao;

import com.wang.gp.pojo.Admin;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AdminDao {

    //查询管理员昵称、密码是否正确
    public Admin confirmAdmin(String adname, String pwd);

    //查询该管理员昵称是否存在
    public Admin confirmAdminAdname(String adname);

    //注册添加管理员
    public int registerAdmin(String adname, String pwd);
}
