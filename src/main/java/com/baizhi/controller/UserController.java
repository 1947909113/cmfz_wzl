package com.baizhi.controller;

import com.baizhi.entity.User;
import com.baizhi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/login")
    public String login(User user, HttpServletRequest request, String enCode){
        HttpSession session = request.getSession();
        User user1 = userService.findOne(user);
        String code = (String) session.getAttribute("validationCode");
        if(code.equals(enCode) && user1!=null){
            session.setAttribute("success",user1);
            return "redirect:/main.jsp";
        }else{
            return "redirect:/login.jsp";
        }
    }

    @RequestMapping("/register")
    public String register(User user){
        userService.add(user);
        return "redirect:/login.jsp";
    }

    @RequestMapping("/edit")
    public @ResponseBody
    Map<String,Object> edit(User user){
        Map<String,Object> results=new HashMap<String,Object>();
        try {
            userService.motify(user);
            results.put("success",true);
        }catch (Exception e){
            e.printStackTrace();
            results.put("success",false);
            results.put("message",e.getMessage());
        }
        return results;
    }
}
