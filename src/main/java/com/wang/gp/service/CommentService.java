package com.wang.gp.service;

import com.wang.gp.pojo.Comment;

import java.util.List;

public interface CommentService {
    //根据Foodinfo的id查询评论
    List<Comment> findCommentByFoodinfoId(Long foodinfoId);
    //添加一个评论
//    int addComment(Comment comment);

    int addComment(String commentContent, Long foodinfoId);
}
