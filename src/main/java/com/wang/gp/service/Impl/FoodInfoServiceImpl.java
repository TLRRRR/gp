package com.wang.gp.service.Impl;

import com.wang.gp.dao.FoodInfoDao;
import com.wang.gp.service.FoodInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FoodInfoServiceImpl implements FoodInfoService {

    @Autowired
    FoodInfoDao foodInfoDao;
    @Override
    public int editInfo(int id, String title, String date, String content) {
        return foodInfoDao.editInfo(id,title,date,content);
    }

    @Override
    public int deleteInfo(int id) {
        return foodInfoDao.deleteInfo(id);
    }

    @Override
    public int addInfo(String title, String content, String date) {
        return foodInfoDao.addInfo(title,content,date);
    }
}
