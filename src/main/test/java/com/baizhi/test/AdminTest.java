package com.baizhi.test;

import com.baizhi.entity.Admin;
import com.baizhi.service.AdminService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class AdminTest extends BasicTest{

    @Autowired
    private AdminService adminService;

    @Test
    public void TestLogin(){
        Admin admin = new Admin();
        admin.setPhone("123");
        admin.setPassword("123456");
        Admin one = adminService.findOne(admin);
        System.out.println(one);

    }
    @Test
    public void updatepwd(){
        Admin admin = new Admin();
        admin.setId("1");
        admin.setPassword("123123");
        adminService.motify(admin);
    }
}