package com.wang.gp.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FoodType {
    private long id;
    private String name;
    private List<FoodInfo> foodInfoList = new ArrayList<>();
}
