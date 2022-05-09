package com.wang.gp.service.Impl;

import com.wang.gp.dao.QueryFoodbookDao;
import com.wang.gp.pojo.Foodbook;
import com.wang.gp.service.QueryFoodbookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QueryFoodbookServiceImpl implements QueryFoodbookService {

    @Autowired
    QueryFoodbookDao hypertensionDao;

    @Override
    public Foodbook queryAllHypertensionByFood(String foodmenu) {
        return hypertensionDao.queryAllHypertensionByFood(foodmenu);
    }
}
