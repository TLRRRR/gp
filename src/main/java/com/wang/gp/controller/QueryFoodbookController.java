package com.wang.gp.controller;

import com.wang.gp.dao.QueryFoodbookDao;
import com.wang.gp.pojo.Foodbook;
import com.wang.gp.pojo.base.baseEntity;
import com.wang.gp.service.QueryFoodbookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/query")
public class QueryFoodbookController {

    @Autowired
    QueryFoodbookDao queryFoodbookDao;

    @RequestMapping("/foodbookquery")
    public baseEntity queryHypertension(String foodmenu, String typew) {
        System.out.println("食谱查询：" + foodmenu + "======" + typew);
        Foodbook foodbook = queryFoodbookDao.queryFoodbookBynameAndType(foodmenu, typew);
        if (foodbook == null) {
            return baseEntity.failed("暂无相关数据");
        } else {
            return baseEntity.success(foodbook);
        }

    }
}
