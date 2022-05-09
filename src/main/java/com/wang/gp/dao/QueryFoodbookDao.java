package com.wang.gp.dao;

import com.wang.gp.pojo.Foodbook;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface QueryFoodbookDao {
    //根据名称查询
    public Foodbook queryAllHypertensionByFood(String foodmenu);

    //根据食谱名称和食谱类型模糊查询食谱
    public Foodbook queryFoodbookBynameAndType(String foodmenu,String typew);
}
