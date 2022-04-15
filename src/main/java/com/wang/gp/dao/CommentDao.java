package com.wang.gp.dao;

import com.wang.gp.pojo.Comment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CommentDao {
//    //根据创建时间倒序来排
//    List<Comment> findByBlogIdParentIdNull(@Param("foodinfoId") Long blogId, @Param("blogParentId") Long blogParentId);
//
//    //查询一级回复
//    List<Comment> findByBlogIdParentIdNotNull(@Param("foodinfoId") Long blogId, @Param("id") Long id);
//
//    //查询二级回复
//    List<Comment> findByBlogIdAndReplayId(@Param("foodinfoId") Long blogId,@Param("childId") Long childId);
//
//    //查询父级对象
////    Comment findByParentCommentId(Long parentCommentId);
//
//    //删除评论
//    void deleteComment(Long id);

    //根据Foodinfo的id查询评论
    List<Comment> findCommentByFoodinfoId(Long foodinfoId);

    //添加一个评论
//    int addComment(Comment comment);
    int addComment(String commentContent, Long foodinfoId);
}
