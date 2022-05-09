package com.wang.gp.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wang.gp.dao.FoodInfoDao;
import com.wang.gp.pojo.Comment;
import com.wang.gp.pojo.FoodInfo;
import com.wang.gp.pojo.base.baseEntity;
import com.wang.gp.service.CommentService;
import com.wang.gp.service.FoodInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/comment")
public class CommentController {

    @Autowired
    FoodInfoService foodInfoService;

    @Autowired
    FoodInfoDao foodInfoDao;

    @Autowired
    CommentService commentService;

    //添加评论
    @RequestMapping("/addcomment")
    public baseEntity addComment(Long id, int pageNum, int pageSize, String commentContent, String commentAuthor) {
        System.out.println(id + "=====" + pageNum + "=====" + pageSize + "=====" + commentContent + "===" + commentAuthor);
        PageHelper.startPage(pageNum, pageSize);
//        ArrayList<FoodInfo> list = foodInfoService.queryFoodInfo();//分页后的信息
        ArrayList<FoodInfo> list = foodInfoDao.queryFoodInfoByDateDesc();
        PageInfo<FoodInfo> foodInfoPageInfo = new PageInfo<>(list);
        //添加评论到相应的文章下
        long foodinfoId = list.get(Math.toIntExact(id)).getId();
        System.out.println(foodinfoId);
        Date creationtime = new Date();
        int i = commentService.addComment(commentContent, foodinfoId, commentAuthor, creationtime);
        List<Comment> commentByFoodinfoId = commentService.findCommentByFoodinfoId(list.get(Math.toIntExact(id)).getId());//文章内容
        System.out.println(commentContent);
        return baseEntity.success(commentByFoodinfoId);
    }
}
