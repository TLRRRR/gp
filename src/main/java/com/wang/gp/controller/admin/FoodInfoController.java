package com.wang.gp.controller.admin;

import com.wang.gp.dao.FoodInfoDao;
import com.wang.gp.pojo.FoodInfo;
import com.wang.gp.pojo.base.baseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/admin")
public class FoodInfoController {

    @Autowired
    FoodInfoDao foodInfoDao;

    //显示所有食物信息
    @ResponseBody
    @RequestMapping("/toinfo")
    public baseEntity<ArrayList> allInfo() {
        ArrayList<FoodInfo> list = foodInfoDao.queryFoodInfo();
        System.out.println(list);
        System.out.println("success1: " + baseEntity.success1(list));
        System.out.println("success: " + baseEntity.success(list));
//        return "admin/foodinfo";
        return baseEntity.success1(list);
    }

    //添加食物信息后跳转到食物信息博客页面
    @ResponseBody
    @RequestMapping("/addinfo")
    public Map<String, String> addInfo(String title, String content, Date date, String flag, Long typeId, String description) {
        System.out.println("foodinfo :" + title + "  " + content);
        System.out.println("dame long   " + typeId);
        int i = foodInfoDao.addFoodInfo(title, content, new Date(), flag, typeId, description);
        HashMap<String, String> map = new HashMap<String, String>();
        map.put("code", "11");
        System.out.println(map);
        return map;
    }

    //删除食物信息
    @ResponseBody
    @RequestMapping("/deleteinfo")
    public baseEntity deleteInfo(Long id) {
        foodInfoDao.deleteFoodinfoById(id);
        System.out.println("删除id为" + id + "的信息");
        return baseEntity.success2();
    }

    //更新食物信息
    @ResponseBody
    @RequestMapping("/updateinfo")
    public void updateInfo(Long id, String title, String content, Long typeId, String flag) {
        System.out.println(id + title + content + typeId + flag);
//        foodInfoDao.updateFoodInfo(id, title, content, typeId, flag);

    }
}
