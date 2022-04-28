package com.wang.gp.dao;

import com.wang.gp.pojo.Hypertension;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface HypertensionDao {
    //根据名称查询
    public Hypertension queryAllByFood(String foodmenu);
}
