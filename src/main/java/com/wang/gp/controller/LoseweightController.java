package com.wang.gp.controller;

import com.wang.gp.pojo.Hyperlipidemia;
import com.wang.gp.pojo.Loseweight;
import com.wang.gp.pojo.base.baseEntity;
import com.wang.gp.service.LoseweightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/query")
public class LoseweightController {

    @Autowired
    LoseweightService loseweightService;

    @RequestMapping("/loseweight")
    public baseEntity queryLoseweight(String foodmenu) {
        System.out.println(foodmenu);
        Loseweight loseweight = loseweightService.queryAllByFood(foodmenu);
        return baseEntity.success(loseweight);
    }
}
