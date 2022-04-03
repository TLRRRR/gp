//package com.wang.gp.controller.admin;
//
//import com.wang.gp.pojo.FoodType;
//import com.wang.gp.service.FoodTypeService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//@Controller
//@RequestMapping("/admin")
//public class FoodTypeController {
//
//    @Autowired
//    FoodTypeService foodTypeService;
//
//    @RequestMapping("/tofoodtype")
//    public String toFoodType(){
//        return "/admin/foodtype";
//    }
//
//    @RequestMapping("/toaddtype")
//    public String toAddType(){
//        return "/admin/addtype";
//    }
//
//    @RequestMapping("/toedittype")
//    public String toUpdateType(FoodType foodType){
//        int i = foodTypeService.updateFoodType(foodType);
//        return "/admin/addtype";
//    }
//
//    @RequestMapping("/todeletetype")
//    public String toDeleteType(Long id){
//        foodTypeService.deleteFoodInfoById(id);
//        return "/admin/addtype";
//    }
//
//}
