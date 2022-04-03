package com.wang.gp.controller.admin;

import com.wang.gp.dao.FoodInfoDao;
import com.wang.gp.pojo.FoodInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Date;

@Controller
@RequestMapping("/admin")
public class FoodInfoController {

    @Autowired
    FoodInfoDao foodInfoDao;

    @RequestMapping("/toinfo")
    public String allInfo(Model model) {
        ArrayList<FoodInfo> list = foodInfoDao.queryFoodInfo();
        model.addAttribute("list", list);
        System.out.println("重定向了吗麻蛋");
        return "admin/foodinfo";
    }

    //跳转到新增食物信息博客页面
    @RequestMapping("/toaddinfo")
    public String toAddInfo() {
        return "admin/addinfo";
    }

    //    @RequestMapping("/addinfo")
//    public String addInfo(String title,String content,String date){
//        foodInfoDao.addFoodInfo(title,content,date);
//    }
    //添加食物信息后跳转到食物信息博客页面
    @RequestMapping("/addinfo")
    public String addInfo(String title, String content, Date date, String flag, Long typeId) {
        System.out.println("anything here in controller???");
        System.out.println("foodinfo :" + title +"  "+ content);
        System.out.println("dame long   "+typeId);
        int i = foodInfoDao.addFoodInfo(title, content, new Date(), flag, typeId);
        return "redirect:/admin/toinfo";
    }

    @RequestMapping("/deleteinfo")
    public String deleteInfo(String title) {
        foodInfoDao.deleteFoodInfoByTitle(title);
        return "redirect:/admin/toinfo";
    }

    @RequestMapping("/toeditinfo")
    public String toEditInfo() {
        return "editinfo";
    }

    public String editInfo(FoodInfo foodInfo) {
        foodInfoDao.updateFoodInfo(foodInfo);
        return "redirect:/admin/toinfo";
    }
}
