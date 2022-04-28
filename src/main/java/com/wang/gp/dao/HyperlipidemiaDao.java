package com.wang.gp.dao;

import com.wang.gp.pojo.Hyperlipidemia;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface HyperlipidemiaDao {
    //根据名称查询
    public Hyperlipidemia queryAllByFood(String foodmenu);
}
