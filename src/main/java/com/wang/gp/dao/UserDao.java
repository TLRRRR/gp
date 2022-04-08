package com.wang.gp.dao;

import com.wang.gp.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface UserDao {
    public User selectUserById(int userId);

    public User queryUser(@Param("user") User user);

    public User registerQueryUser(String userName);

    public User queryUserByTel(String tel);

    public int registerUser(String userName, String pwd, String tel);

    public int updatePwd(String userName, String pwd, String tel);
}
