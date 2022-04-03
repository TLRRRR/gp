package com.wang.gp.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FoodInfo {
    private int id;
    private String title;
    private String content;
    private Date date;
    private String flag;
    private Long typeId;
}
