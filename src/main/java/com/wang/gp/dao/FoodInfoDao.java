package com.wang.gp.dao;

import com.wang.gp.pojo.FoodInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.ArrayList;
import java.util.Date;

@Mapper
public interface FoodInfoDao {


    //添加信息
    public int addFoodInfo(String title, String content, Date date, String flag,Long typeId);

    //删除信息
    public int deleteFoodInfoByTitle(String title);

    //编辑信息
    public int updateFoodInfo(FoodInfo foodInfo);

    //根据title查询信息
    public FoodInfo queryFoodInfoByTitle(String title);

    //查询所有信息
    public ArrayList<FoodInfo> queryFoodInfo();
}
