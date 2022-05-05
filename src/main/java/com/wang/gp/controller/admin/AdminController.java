package com.wang.gp.controller.admin;

import com.wang.gp.pojo.Admin;
import com.wang.gp.pojo.base.baseEntity;
import com.wang.gp.service.AdminService;
import com.wang.gp.utils.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/adminadmin")
public class AdminController {

    @Autowired
    AdminService adminService;

    //验证登录
    @RequestMapping("/confirmAdmin")
    public baseEntity confirmAdmin(String adname, String pwd) {
        System.out.println("confirmAdmin");
        String s = adminService.adminLogin(adname, MD5Utils.getMD5(pwd));
        Admin admin = new Admin();
        admin.setAdname(adname);
        if (s == "success") {
            return baseEntity.success(adname);
        } else {
            return baseEntity.success1(Integer.parseInt(s));
        }
    }

    //注册
    @RequestMapping("/registeradmin")
    public baseEntity registerAdmin(String adname, String pwd) {
        System.out.println("registerAdmin");
        String s = adminService.registerAdmin(adname, MD5Utils.getMD5(pwd));
        Admin admin = new Admin();
        admin.setAdname(adname);
        System.out.println(s);
        return baseEntity.success3(admin, Integer.parseInt(s));
    }
}
