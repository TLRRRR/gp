package com.wang.gp.controller.admin;

import com.wang.gp.dao.FoodInfoDao;
import com.wang.gp.pojo.FoodInfo;
import com.wang.gp.pojo.base.baseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;

@Controller
@RequestMapping("/admin")
public class FoodInfoController {

    @Autowired
    FoodInfoDao foodInfoDao;

    //显示所有食物信息
    @ResponseBody
    @RequestMapping("/allfoodinfo")
    public baseEntity<ArrayList> queryFoodInfo() {
        System.out.println("queryFoodInfo");
        ArrayList<FoodInfo> list = foodInfoDao.queryFoodInfo();
        return baseEntity.success1(list);
    }

    //显示用户发布的文章
    @ResponseBody
    @RequestMapping("/toinfo")
    public baseEntity<ArrayList> queryInfoByTitle(String userName, String title) {
        System.out.println("用户名" + userName);
        ArrayList<FoodInfo> list1 = foodInfoDao.queryFoodinfoByUsername(userName);
        return baseEntity.success1(list1);
    }

    //添加食物信息后跳转到食物信息博客页面
    @ResponseBody
    @RequestMapping("/addinfo")
    public Map<String, String> addInfo(String title, String content, Date date, String flag, String typew, String description, String author) {
        System.out.println("foodinfo :" + title + "  " + content);
        System.out.println("dame long   " + typew);
        int i = foodInfoDao.addFoodInfo(title, content, new Date(), flag, typew, description, author);
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
    }

    //显示文章类别列表
    @ResponseBody
    @RequestMapping("/showinfotype")
    public baseEntity showInfotype() {
        System.out.println("show foodinfo type");
        List list = foodInfoDao.showInfotype();
        return baseEntity.success(list);
    }
}
