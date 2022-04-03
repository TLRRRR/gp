package com.wang.gp.service.Impl;

import com.wang.gp.dao.FoodInfoDao;
import com.wang.gp.pojo.FoodInfo;
import com.wang.gp.service.FoodInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;

@Service
public class FoodInfoServiceImpl implements FoodInfoService {

    @Autowired
    FoodInfoDao foodInfoDao;

    @Override
    public int addFoodInfo(String title, String content, Date date, String flag, Long typeId) {
        return foodInfoDao.addFoodInfo(title,content,date,flag,typeId);
    }

    @Override
    public int deleteFoodInfoByTitle(String title) {
        return foodInfoDao.deleteFoodInfoByTitle(title);
    }

    @Override
    public int updateFoodInfo(FoodInfo foodInfo) {
        return foodInfoDao.updateFoodInfo(foodInfo);
    }

    @Override
    public FoodInfo queryFoodInfoByTitle(String title) {
        return foodInfoDao.queryFoodInfoByTitle(title);
    }

    @Override
    public ArrayList<FoodInfo> queryFoodInfo() {
        return foodInfoDao.queryFoodInfo();
    }
}
