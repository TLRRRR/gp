package com.wang.gp.controller;

import com.wang.gp.pojo.Hypertension;
import com.wang.gp.pojo.base.baseEntity;
import com.wang.gp.service.HypertensionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/query")
public class HypertensionController {

    @Autowired
    HypertensionService hypertensionService;

    @RequestMapping("/hypertension")
    public baseEntity queryHypertension(@RequestParam String foodmenu) {
        System.out.println(foodmenu);
        Hypertension hypertension = hypertensionService.queryAllByFood(foodmenu);
        System.out.println("-----------" + hypertension);
        return baseEntity.success(hypertension);
    }
}
