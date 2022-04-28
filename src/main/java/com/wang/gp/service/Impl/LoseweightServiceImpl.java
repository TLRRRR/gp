package com.wang.gp.service.Impl;

import com.wang.gp.dao.LoseweightDao;
import com.wang.gp.pojo.Loseweight;
import com.wang.gp.service.LoseweightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoseweightServiceImpl implements LoseweightService {

    @Autowired
    LoseweightDao loseweightDao;

    @Override
    public Loseweight queryAllByFood(String foodmenu) {
        return loseweightDao.queryAllByFood(foodmenu);
    }
}
