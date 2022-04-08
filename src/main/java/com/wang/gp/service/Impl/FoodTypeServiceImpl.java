package com.wang.gp.service.Impl;

import com.wang.gp.dao.FoodTypeDao;
import com.wang.gp.pojo.FoodType;
import com.wang.gp.service.FoodTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoodTypeServiceImpl implements FoodTypeService {

    @Autowired
    FoodTypeDao foodTypeDao;

    @Override
    public FoodType queryFoodTypeById(Long id) {
        return foodTypeDao.queryFoodTypeById(id);
    }

    @Override
    public List<FoodType> queryAllFoodType() {
        return foodTypeDao.queryAllFoodType();
    }

    @Override
    public List<FoodType> queryAllFoodTypeAndBlog() {
        return foodTypeDao.queryAllFoodTypeAndBlog();
    }

    @Override
    public FoodType queryFoodTypeByName(String name) {
        return foodTypeDao.queryFoodTypeByName(name);
    }

    @Override
    public int addFoodType(String name) {
        return foodTypeDao.addFoodType(name);
    }

//    @Override
//    public int addFoodType(FoodType foodType) {
//        return foodTypeDao.addFoodType(foodType);
//    }

    @Override
    public int deleteFoodInfoById(Long id) {
        return foodTypeDao.deleteFoodInfoById(id);
    }

    @Override
    public int updateFoodType(FoodType foodType) {
        return foodTypeDao.updateFoodType(foodType);
    }
}
