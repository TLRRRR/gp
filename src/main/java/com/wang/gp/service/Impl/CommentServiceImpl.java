package com.wang.gp.service.Impl;

import com.wang.gp.dao.CommentDao;
import com.wang.gp.pojo.Comment;
import com.wang.gp.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    CommentDao commentDao;

    @Override
    public List<Comment> findCommentByFoodinfoId(Long foodinfoId) {
        return commentDao.findCommentByFoodinfoId(foodinfoId);
    }

    @Override
    public int addComment(String commentContent, Long foodinfoId, String commentAuthor, Date creationtime) {
        return commentDao.addComment(commentContent, foodinfoId, commentAuthor, creationtime);
    }

//    @Override
//    public int addComment(Comment comment) {
//        return commentDao.addComment(comment);
//    }
}
