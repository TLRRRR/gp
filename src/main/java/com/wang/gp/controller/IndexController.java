package com.wang.gp.controller;

import com.wang.gp.pojo.FoodInfo;
import com.wang.gp.pojo.base.baseEntity;
import com.wang.gp.service.FoodInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Controller
public class IndexController {

    @Autowired
    FoodInfoService foodInfoService;

    //显示所有食物信息
    @ResponseBody
    @RequestMapping("/allinfo")
    public baseEntity<ArrayList> allInfo() {
        ArrayList<FoodInfo> list = foodInfoService.queryFoodInfo();
        System.out.println(list);
        System.out.println("success: " + baseEntity.success(list));
        return baseEntity.success(list);
    }

//    @ResponseBody
//    @RequestMapping("/foodinfo")
//    public Map<String, String> foodinfo(Long id, Model model) {
//        System.out.println(id);
//        FoodInfo foodInfo = foodInfoService.queryFoodInfoById(id);
//        System.out.println("this is my foodinfo: " + foodInfo);
////        List<Comment> comments = commentService.listCommentByBlogId(id);
////        model.addAttribute("comments", comments);
//        model.addAttribute("info", foodInfo);
//        Map<String, String> map = new HashMap<String, String>();
//        map.put("code","200");
//        return map;
//    }

    @ResponseBody
    @RequestMapping("/foodinfo")
    public baseEntity<FoodInfo> foodinfo(Long id) {
        System.out.println(id);
        FoodInfo foodInfo = foodInfoService.queryFoodInfoById(id);
        System.out.println("this is my foodinfo: " + baseEntity.success(foodInfo));
        return baseEntity.success(foodInfo);
    }
}
