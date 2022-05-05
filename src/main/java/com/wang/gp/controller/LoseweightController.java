package com.wang.gp.controller;

import com.wang.gp.pojo.Foodbook;
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
        System.out.println("减肥食谱："+foodmenu);
        Foodbook foodbook = loseweightService.queryAllLoseweightByFood(foodmenu);
        return baseEntity.success(foodbook);
    }
}
