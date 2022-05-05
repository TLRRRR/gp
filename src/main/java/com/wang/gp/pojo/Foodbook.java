package com.wang.gp.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Foodbook {
    private long id;
    private String author;
    private String foodMenu;
    private String description;
    private String formula;
    private String usagew;
    private Date creationtime;
    private String typew;
}
