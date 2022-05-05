package com.wang.gp.dao;

import com.wang.gp.pojo.Foodbook;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface HypertensionDao {
    //根据名称查询
    public Foodbook queryAllHypertensionByFood(String foodmenu);
}
