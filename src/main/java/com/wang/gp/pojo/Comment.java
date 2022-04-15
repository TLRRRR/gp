package com.wang.gp.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Comment {
    private Long id;
    private String username;
    private String content;
    private Date createTime;
    private Long foodinfoId;
    private Long parentCommentId;
}
