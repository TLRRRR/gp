package com.wang.gp.controller;

import com.wang.gp.pojo.base.baseEntity;
import com.wang.gp.pojo.baseTest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class baseTestC {

    @RequestMapping("/666")
    public baseEntity<baseTest> getU() {
        baseTest t = baseTest.builder()
                .name("john")
                .pwd("123")
                .date(new Date())
                .build();

        return baseEntity.success(t);
    }

    @RequestMapping("/777")
    public baseEntity<baseTest> getUU(String name,String pwd){
        if(name.equalsIgnoreCase("me")&&pwd.equalsIgnoreCase("666")){
            baseTest t = baseTest.builder()
                    .name("john")
                    .pwd("123")
                    .date(new Date())
                    .build();
            return baseEntity.success(t);
        }else {
            return baseEntity.failed("name and pwd wrong");
        }
    }
}
