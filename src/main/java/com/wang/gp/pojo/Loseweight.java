package com.wang.gp.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Loseweight {
    private long id;
    private String foodMenu;
    private String effect;
    private String formula;
    private String usage;
}
