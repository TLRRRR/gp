package com.wang.gp.dao;

import com.wang.gp.pojo.Login;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;

@Mapper
public interface LoginDao {
    //查询错误登录
    public Login queryUser(String userName);
    //添加错误登录
    public int insertUser(@Param("userName") String userName,@Param("errorLoginTime") Date errorLoginTime,@Param("count") int count);
    //更新错误登录
    public int updateUser(@Param("userName") String userName,@Param("errorLoginTime") Date errorLoginTime,@Param("count") int count );
}
