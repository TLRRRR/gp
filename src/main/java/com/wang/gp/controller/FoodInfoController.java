package com.wang.gp.controller;

import com.wang.gp.dao.FoodInfoDao;
import com.wang.gp.pojo.FoodInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;

@Controller
@RequestMapping("/foodinfo")
public class FoodInfoController {

    @Autowired
    FoodInfoDao foodInfoDao;

    @RequestMapping("/toinfo")
    public String allInfo(Model model) {
        ArrayList<FoodInfo> list = foodInfoDao.queryFoodInfo();
        model.addAttribute("list",list);
        return "foodinfo";
    }

    @RequestMapping("/toaddinfo")
    public String toAddInfo() {
        return "addinfo";
    }

    //    @GetMapping("/addinfo")
//    public String addInfo(String title,String content,String date){
//        foodInfoDao.addFoodInfo(title,content,date);
//    }
    @RequestMapping("/addinfo")
    public String addInfo(FoodInfo foodInfo) {
        foodInfoDao.addFoodInfo(foodInfo);
        return "redirect:foodinfo/toinfo";
    }

    @RequestMapping("/deleteinfo")
    public String deleteInfo(String title) {
        foodInfoDao.deleteFoodInfoByTitle(title);
        return "redirect:foodinfo/toinfo";
    }

    @RequestMapping("/toeditinfo")
    public String toEditInfo() {
        return "editinfo";
    }

    public String editInfo(FoodInfo foodInfo) {
        foodInfoDao.updateFoodInfo(foodInfo);
        return "redirect:foodinfo/toinfo";
    }
}
