package com.wang.gp.dao;

import com.wang.gp.pojo.Loseweight;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface LoseweightDao {
    //根据名称查询
    public Loseweight queryAllByFood(String foodmenu);
}
