package com.wang.gp.service.Impl;

import com.wang.gp.dao.HyperlipidemiaDao;
import com.wang.gp.pojo.Hyperlipidemia;
import com.wang.gp.service.HyperlipidemiaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HyperlipidemiaServiceImpl implements HyperlipidemiaService {

    @Autowired
    HyperlipidemiaDao hyperlipidemiaDao;

    @Override
    public Hyperlipidemia queryAllByFood(String foodmenu) {
        return hyperlipidemiaDao.queryAllByFood(foodmenu);
    }
}
