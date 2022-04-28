package com.wang.gp.controller;

import com.wang.gp.pojo.Hyperlipidemia;
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
        System.out.println(foodmenu);
        Hyperlipidemia hyperlipidemia = hyperlipidemiaService.queryAllByFood(foodmenu);
        System.out.println("--------------"+hyperlipidemia);
        return baseEntity.success(hyperlipidemia);
    }
}
