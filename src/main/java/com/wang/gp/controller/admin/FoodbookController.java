package com.wang.gp.controller.admin;

import com.wang.gp.pojo.Foodbook;
import com.wang.gp.pojo.base.baseEntity;
import com.wang.gp.service.FoodbookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/admin")
public class FoodbookController {

    @Autowired
    FoodbookService foodbookService;

    //展示所有食谱
    @RequestMapping("/allfoodbook")
    public baseEntity allFoodbook() {
        System.out.println("allfoodbook");
        ArrayList<Foodbook> foodbooks = foodbookService.allFoodbook();
        return baseEntity.success1(foodbooks);
    }

    //展示用户所发表的所有食谱
    @RequestMapping("/allauthorfoodbook")
    public baseEntity allAuthorFoodbook(String author) {
        System.out.println(author);
        ArrayList<Foodbook> foodbooks = foodbookService.allAuthorFoodbook(author);
        return baseEntity.success1(foodbooks);
    }

    //添加食谱
    @RequestMapping("/addfoodbook")
    public baseEntity addfoodbook(String foodMenu, String description, String formula, String usagew, String author, String typew) {
        Date creationtime = new Date();
        int i = foodbookService.addFoodbook(foodMenu, description, formula, usagew, creationtime, author, typew);
        System.out.println(i);
        return baseEntity.success2();
    }

    //根据id删除食谱
    @RequestMapping("/deletefoodbook")
    public baseEntity deletefoodbook(long id) {
        System.out.println("id" + id);
        int deletefoodbook = foodbookService.deletefoodbook(id);
        return baseEntity.success2();
    }

    //修改编辑食谱
    @RequestMapping("/updatefoodbook")
    public baseEntity updatefoodbook(Long id, String foodMenu, String description, String formula, String usagew) {
        System.out.println(id);
        int updatefoodbook = foodbookService.updatefoodbook(id, foodMenu, description, formula, usagew);
        return baseEntity.success2();
    }

    //展示食谱类型列表
    @RequestMapping("/showfoodbooktype")
    public baseEntity showFoodbookType() {
        System.out.println("show foodbook type");
        List list = foodbookService.showFoodbookType();
        return baseEntity.success(list);
    }

}
