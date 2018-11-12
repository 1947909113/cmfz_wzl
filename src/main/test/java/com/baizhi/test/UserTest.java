package com.baizhi.test;

import com.baizhi.entity.Admin;
import com.baizhi.entity.User;
import com.baizhi.service.AdminService;
import com.baizhi.service.UserService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class UserTest extends BasicTest{

    @Autowired
    private UserService userService;

    @Test
    public void TestLogin(){
        User user = new User();
        user.setUsername("123");
        user.setPassword("123456");
        User one = userService.findOne(user);
        System.out.println(one);

    }
    @Test
    public void updatepwd(){
        User user = new User();
        user.setId("1");
        user.setStatus("n");
        userService.motify(user);
    }

    @Test
    public void registe(){
        User user = new User();
        user.setId("2");
        user.setUsername("456");
        user.setPassword("666");
        userService.add(user);
    }
}