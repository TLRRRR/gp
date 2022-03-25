package com.wang.gp.service;

import com.wang.gp.pojo.FoodInfo;

import java.util.ArrayList;

public interface FoodInfoService {

    //添加信息
    public int addFoodInfo(FoodInfo foodInfo);

    //删除信息
    public int deleteFoodInfoByTitle(String title);

    //编辑信息
    public int updateFoodInfo(FoodInfo foodInfo);

    //根据title查询信息
    public FoodInfo queryFoodInfoByTitle(String title);

    //查询所有信息
    public ArrayList<FoodInfo> queryFoodInfo();
}
