package com.wang.gp.controller.admin;

import com.wang.gp.pojo.FoodType;
import com.wang.gp.pojo.base.baseEntity;
import com.wang.gp.service.FoodTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/admin")
public class FoodTypeController {

    @Autowired
    FoodTypeService foodTypeService;

    @RequestMapping("/tofoodtype")
    public String toFoodType() {
        return "/admin/foodtype";
    }

    @RequestMapping("/toaddtype")
    public String toAddType() {
        return "/admin/addtype";
    }

    @ResponseBody
    @RequestMapping("/totype")
    public baseEntity allType() {
        List<FoodType> foodTypes = foodTypeService.queryAllFoodType();
        System.out.println(foodTypes);
        System.out.println("successEntity: " + baseEntity.success(foodTypes));
        return baseEntity.success1(foodTypes);
    }

    @RequestMapping("/addtype")
    @ResponseBody
    public Map<String, String> addType(@RequestBody Map<String, String> name) {
//    public String addType(@RequestBody Map<String,String> name) {
        System.out.println("this shit is my name: " + name);
        System.out.println(name.get("name"));
        FoodType foodType = foodTypeService.queryFoodTypeByName(name.get("name"));
        System.out.println(foodType);
        Map<String, String> map = new HashMap<String, String>();
        if (foodType == null) {
            System.out.println("u can add this type");
            Integer num = foodTypeService.addFoodType(name.get("name"));
            System.out.println("成功添加数据条数" + num);
            map.put("code", "200");
            map.put("mas", "登陆成功");
        } else {
            System.out.println("this type is already exist");
            map.put("code", "11");
            map.put("mas", "类型存在");
        }
        return map;
    }

    @ResponseBody
    @RequestMapping("/deletetype")
    public void deleteType(Long id) {
        foodTypeService.deleteFoodInfoById(id);
        System.out.println("删除这个id：" + id);
    }

    @ResponseBody
    @RequestMapping("/updatetype")
    public void updateType(FoodType foodType, Long id, String name) {
        System.out.println(foodType.getId());
        System.out.println(name);
        foodTypeService.updateFoodType(id, name);
        System.out.println("删除这个id：" + name);
    }

    /**
     * @param
     * @return
     */
//    @RequestMapping("/addtype")
//    @ResponseBody
////    public baseEntity<FoodType> addType(@RequestBody String name) {
//    public String addType(FoodType type, String name) {
//        System.out.println("this shit is my name: " + type);
////        System.out.println("or this shit is my name: "+name);
////        FoodType foodType1 = foodTypeService.queryFoodTypeByName(name);
////        FoodType foodType = foodTypeService.queryFoodTypeByName(name);
////        FoodType foodType1 = new FoodType();
////        foodType1.setName(name);
////        System.out.println(foodType);
////        Map<String,String> map=new HashMap<String,String>();
//        if (type == null) {
//            System.out.println("u can add the type" + type);
////            foodTypeService.addFoodType(name);
//            System.out.println("tianjiachenggong");
////            Integer num=foodTypeService.addFoodType(foodType1.getName());
////            foodTypeService.addFoodType(foodType1);
////            System.out.println("成功添加数据条数"+num);
//            return "jiji";
////            return "{\"errorCode\":\"12\",\"errorMessage\":\"登陆成功！\"}";
////            map.put("code","12");
////            map.put("mas","登陆成功");
//            //            return Result.error("12","登录成功");
//        } else {
//            System.out.println("this type is already exist");
//            return "nono";
////            return "{\"errorCode\":\"11\",\"errorMessage\":\"登陆成功！\"}";
////            return Result.error("11","登录成功");
////            map.put("code","11");
////            map.put("mas","登陆成功");
//        }
////        return map;
//
//    }


//    @RequestMapping("/toedittype")
//    public String toUpdateType(FoodType foodType) {
//        int i = foodTypeService.updateFoodType(foodType);
//        return "/admin/addtype";
//    }

    @RequestMapping("/todeletetype")
    public String toDeleteType(Long id) {
        foodTypeService.deleteFoodInfoById(id);
        return "/admin/addtype";
    }


}
