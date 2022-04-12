package com.wang.gp.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wang.gp.pojo.FoodInfo;
import com.wang.gp.pojo.base.baseEntity;
import com.wang.gp.service.FoodInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
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
    public baseEntity<ArrayList> allInfo(HttpServletResponse httpServletResponse, String l) {
        System.out.println("it is controller");
        System.out.println("----------" + l);
        if (l != null && l.equalsIgnoreCase("last")) {
//            pageNum+=1;
            System.out.println("first if: " + l);
        } else if (l != null && l.equalsIgnoreCase("next")) {
            System.out.println("second if: " + l);
        }
        int pageNum = 1, i = 0;
        PageHelper.startPage(pageNum, 6);
        ArrayList<FoodInfo> list = foodInfoService.queryFoodInfo();
        PageInfo<FoodInfo> foodInfoPageInfo = new PageInfo<>(list);
//        System.out.println("success: " + baseEntity.success(list));
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

//    @ResponseBody
//    @RequestMapping("/foodinfo")
//    public baseEntity<FoodInfo> foodInfo(Long id) {
//        System.out.println(id);
//        FoodInfo foodInfo = foodInfoService.queryFoodInfoById(id);
//        System.out.println("this is my foodinfo: " + baseEntity.success(foodInfo));
//        return baseEntity.success(foodInfo);
//    }

    //按id升序从数据库中取食物信息
    @ResponseBody
    @RequestMapping("/infodetail")
    public baseEntity<FoodInfo> infoDetail(Long id) {
        System.out.println(id);
        ArrayList<FoodInfo> list = foodInfoService.queryFoodInfo();
//        System.out.println("this is all my info: " + list);
        System.out.println("because : " + list.get(0));
        return baseEntity.success(list.get(Math.toIntExact(id)));
    }
}
