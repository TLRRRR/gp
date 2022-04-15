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
    public int addFoodInfo(String title, String content, Date date, String flag, Long typeId, String description) {
        return foodInfoDao.addFoodInfo(title, content, date, flag, typeId, description);
    }

    @Override
    public int deleteFoodInfoByTitle(String title) {
        return foodInfoDao.deleteFoodInfoByTitle(title);
    }

    @Override
    public int deleteFoodinfoById(Long id) {
        return foodInfoDao.deleteFoodinfoById(id);
    }

    @Override
    public int updateFoodInfo(Long id, String title, String content, Long typeId, String flag) {
        return foodInfoDao.updateFoodInfo(id, title, content, typeId, flag);
    }

    @Override
    public FoodInfo queryFoodInfoByTitle(String title) {
        return foodInfoDao.queryFoodInfoByTitle(title);
    }

    @Override
    public FoodInfo queryFoodInfoById(Long id) {
        return foodInfoDao.queryFoodInfoById(id);
    }

    @Override
    public FoodInfo queryFoodInfoByIdAsc(Long id) {
        return foodInfoDao.queryFoodInfoByIdAsc(id);
    }

    @Override
    public ArrayList<FoodInfo> queryFoodInfo() {
        return foodInfoDao.queryFoodInfo();
    }

    @Override
    public ArrayList<FoodInfo> queryFoodinfoByUsername(String userName) {
        return foodInfoDao.queryFoodinfoByUsername(userName);
    }
}
