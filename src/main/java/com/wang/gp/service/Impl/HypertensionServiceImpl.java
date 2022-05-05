package com.wang.gp.service.Impl;

import com.wang.gp.dao.HypertensionDao;
import com.wang.gp.pojo.Foodbook;
import com.wang.gp.service.HypertensionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HypertensionServiceImpl implements HypertensionService {

    @Autowired
    HypertensionDao hypertensionDao;

    @Override
    public Foodbook queryAllHypertensionByFood(String foodmenu) {
        return hypertensionDao.queryAllHypertensionByFood(foodmenu);
    }
}
