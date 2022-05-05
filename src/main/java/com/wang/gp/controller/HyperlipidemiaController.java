package com.wang.gp.controller;

import com.wang.gp.pojo.Foodbook;
import com.wang.gp.pojo.base.baseEntity;
import com.wang.gp.service.HyperlipidemiaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/query")
public class HyperlipidemiaController {

    @Autowired
    HyperlipidemiaService hyperlipidemiaService;

    @RequestMapping("/hyperlipidemia")
    public baseEntity queryHyperlipidemia(String foodmenu){
        System.out.println("高血脂食谱："+foodmenu);
        Foodbook foodbook = hyperlipidemiaService.queryAllHyperlipidemiaByFood(foodmenu);
        System.out.println("--------------"+foodbook);
        return baseEntity.success(foodbook);
    }
}
