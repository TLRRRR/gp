package com.wang.gp.service.Impl;

import com.wang.gp.dao.HyperlipidemiaDao;
import com.wang.gp.pojo.Foodbook;
import com.wang.gp.service.HyperlipidemiaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HyperlipidemiaServiceImpl implements HyperlipidemiaService {

    @Autowired
    HyperlipidemiaDao hyperlipidemiaDao;

    @Override
    public Foodbook queryAllHyperlipidemiaByFood(String foodmenu) {
        return hyperlipidemiaDao.queryAllHyperlipidemiaByFood(foodmenu);
    }
}
