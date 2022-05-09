package com.wang.gp.dao;

import com.wang.gp.pojo.FoodType;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface FoodTypeDao {

    public FoodType queryFoodTypeById(Long id);

    public List<FoodType> queryAllFoodType();

    public List<FoodType> queryAllFoodTypeAndBlog();

    public FoodType queryFoodTypeByName(String name);

    public int addFoodType(String name);

    public int deleteFoodInfoById(Long id);

    public int updateFoodType(Long id, String name);

    //根据
    public Long queryTypeidByTypew(String name);
}
