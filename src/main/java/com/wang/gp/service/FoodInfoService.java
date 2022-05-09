package com.wang.gp.service;

import com.wang.gp.pojo.FoodInfo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public interface FoodInfoService {

    //添加信息
    public int addFoodInfo(String title, String content, Date date, String flag, long typeid, String typew, String description, String author);

    //删除信息
    public int deleteFoodInfoByTitle(String title);

    //根据id删除信息
    public int deleteFoodinfoById(Long id);

    //编辑信息
    public int updateFoodInfo(Long id, String title, String content, Long typeId, String flag);

    //根据title查询信息
    public FoodInfo queryFoodInfoByTitle(String title);

    //根据id查询信息
    public FoodInfo queryFoodInfoById(Long id);

    //根据id升序查询信息
    public FoodInfo queryFoodInfoByIdAsc(Long id);

    //查询所有信息
    public ArrayList<FoodInfo> queryFoodInfo();

    //根据用户名查询食物信息文章
    public ArrayList<FoodInfo> queryFoodinfoByUsername(String userName);

    //查询食物文章类型列表
    public List showInfotype();
}
