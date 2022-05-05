package com.wang.gp.controller.admin;

import com.wang.gp.pojo.FoodbookType;
import com.wang.gp.pojo.base.baseEntity;
import com.wang.gp.service.FoodbookTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class FoodbookTypeController {

    @Autowired
    FoodbookTypeService foodbookTypeService;

    //显示所有食谱类别
    @RequestMapping("/queryallfoodbooktype")
    public baseEntity queryAllFoodbookType(){
        System.out.println("foodbooktypes");
        List<FoodbookType> list = foodbookTypeService.queryAllFoodbookType();
        return baseEntity.success1(list);
    }

    //添加食谱分类
    @RequestMapping("/addfoodbooktype")
    public baseEntity addFoodbookType(String name){
        System.out.println("addfoodbooktype");
        foodbookTypeService.addFoodbookType(name);
        return baseEntity.success2();
    }

    //删除食谱分类
    @RequestMapping("/deletefoodbooktypebyid")
    public baseEntity deleteFoodbooktypeById(Long id){
        System.out.println("deletefoodbooktypebyid");
        int i = foodbookTypeService.deleteFoodbooktypeById(id);
        return baseEntity.success2();
    }

    //修改食谱类别
    @RequestMapping("/updatefoodbooktype")
    public baseEntity updateFoodbookType(Long id, String name){
        System.out.println("updatefoodbooktype");
        int i = foodbookTypeService.updateFoodbookType(id, name);
        return baseEntity.success2();
    }
}
