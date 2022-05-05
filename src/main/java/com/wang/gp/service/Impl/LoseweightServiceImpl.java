package com.wang.gp.service.Impl;

import com.wang.gp.dao.LoseweightDao;
import com.wang.gp.pojo.Foodbook;
import com.wang.gp.service.LoseweightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoseweightServiceImpl implements LoseweightService {

    @Autowired
    LoseweightDao loseweightDao;

    @Override
    public Foodbook queryAllLoseweightByFood(String foodmenu) {
        return loseweightDao.queryAllLoseweightByFood(foodmenu);
    }
}
