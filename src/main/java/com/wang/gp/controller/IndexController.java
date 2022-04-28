package com.wang.gp.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wang.gp.pojo.Comment;
import com.wang.gp.pojo.FoodInfo;
import com.wang.gp.pojo.base.baseEntity;
import com.wang.gp.service.CommentService;
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
import java.util.List;
import java.util.Map;

@Controller
public class IndexController {

    @Autowired
    FoodInfoService foodInfoService;

    @Autowired
    CommentService commentService;

    //显示所有食物信息
    @ResponseBody
    @RequestMapping("/allinfo")
    public baseEntity<Integer> allInfo(HttpServletResponse httpServletResponse) {
        ArrayList<FoodInfo> list = foodInfoService.queryFoodInfo();
        Integer size = list.size();
//        PageInfo<FoodInfo> foodInfoPageInfo = new PageInfo<>(list);
        return baseEntity.success(size);
    }

    @ResponseBody
    @RequestMapping("/gapinfo")
    public baseEntity<ArrayList> gapInfo(HttpServletResponse httpServletResponse, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        System.out.println(pageNum + "...." + pageSize);
        ArrayList<FoodInfo> list = foodInfoService.queryFoodInfo();
        PageInfo<FoodInfo> foodInfoPageInfo = new PageInfo<>(list);
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

    //按id从数据库中取食物信息博客详情页
    @ResponseBody
    @RequestMapping("/infodetail")
    public baseEntity<FoodInfo> infoDetail(Long id, int pageNum, int pageSize) {
        System.out.println("详情页的pageNum跟PageSize" + pageNum + "=======" + pageSize);
        PageHelper.startPage(pageNum, pageSize);
        System.out.println("从前端获取的详情页id" + id);
        ArrayList<FoodInfo> list = foodInfoService.queryFoodInfo();
        PageInfo<FoodInfo> foodInfoPageInfo = new PageInfo<>(list);
        System.out.println("this is all my info: " + list.get(Math.toIntExact(id)));
        System.out.println("because : " + list.get(Math.toIntExact(id)).getId());
        return baseEntity.success(list.get(Math.toIntExact(id)));
    }

    //按id从数据库中取食物信息博客详情页
    @ResponseBody
    @RequestMapping("/infocomment")
    public baseEntity<List<Comment>> infoComment(Long id, int pageNum, int pageSize) {
        System.out.println("详情页的pageNum跟PageSize" + pageNum + "=======" + pageSize);
        PageHelper.startPage(pageNum, pageSize);
        System.out.println("从前端获取的详情页id" + id);
        ArrayList<FoodInfo> list = foodInfoService.queryFoodInfo();//分页后的信息
        PageInfo<FoodInfo> foodInfoPageInfo = new PageInfo<>(list);
        System.out.println("this is all my info: " + list);
        System.out.println("because : " + list.get(Math.toIntExact(id)).getId());
        //根据文章id查询对应的评论
        List<Comment> commentByFoodinfoId = commentService.findCommentByFoodinfoId(list.get(Math.toIntExact(id)).getId());
        System.out.println("my comment: " + commentByFoodinfoId);
        return baseEntity.success(commentByFoodinfoId);
    }
}
