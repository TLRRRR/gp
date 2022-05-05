package com.wang.gp.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FoodInfo {
    private Long id;
    private String title;
    private String author;
    private String content;
    private String description;
    private Date date;
    private String flag;
    private Long typeId;
    private String typew;
}
