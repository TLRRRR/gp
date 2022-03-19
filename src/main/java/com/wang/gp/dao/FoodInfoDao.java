package com.wang.gp.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface FoodInfoDao {
    //编辑消息
    public int editInfo(@Param("id") int id, @Param("title") String title, @Param("date") String date, @Param("content") String content);

    //删除消息
    public int deleteInfo(int id);

    //添加消息
    public int addInfo(@Param("title") String title, @Param("content") String content, @Param("date") String date);
}
