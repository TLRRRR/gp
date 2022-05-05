package com.wang.gp.dao;

import com.wang.gp.pojo.Foodbook;
import org.apache.ibatis.annotations.Mapper;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Mapper
public interface FoodbookDao {

    //添加食谱
    public int addFoodbook(String foodMenu, String description, String formula, String usagew, Date creationtime, String author, String typew);

    //展示用户所发表的所有食谱
    public ArrayList<Foodbook> allAuthorFoodbook(String author);

    //展示所有食谱
    public ArrayList<Foodbook> allFoodbook();

    //根据食谱id删除食谱
    public int deletefoodbook(long id);

    //编辑修改食谱
    public int updatefoodbook(Long id, String foodMenu, String description, String formula, String usagew);

    //展示食谱类型列表
    public List showFoodbookType();

}
