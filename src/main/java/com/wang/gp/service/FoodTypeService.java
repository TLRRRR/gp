package com.wang.gp.service;

import com.wang.gp.pojo.FoodType;

import java.util.List;

public interface FoodTypeService {
    public FoodType queryFoodTypeById(Long id);

    public List<FoodType> queryAllFoodType();

    public List<FoodType> queryAllFoodTypeAndBlog();

    public FoodType queryFoodTypeByName(String name);

//    public int addFoodType(FoodType foodType);
//    public int addFoodType(Long id,String name);
    public int addFoodType(String name);

    public int deleteFoodInfoById(Long id);

    public int updateFoodType(FoodType foodType);

//    void addFoodType(int i, String name);
}
