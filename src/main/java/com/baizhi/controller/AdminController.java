package com.baizhi.controller;

import com.baizhi.entity.Admin;
import com.baizhi.entity.Banner;
import com.baizhi.service.AdminService;
import com.sun.org.apache.xpath.internal.operations.Equals;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @RequestMapping("/login")
    public String login(Admin admin, HttpServletRequest request,String enCode){
        HttpSession session = request.getSession();
        Admin  admin1= adminService.findOne(admin);
        String code = (String) session.getAttribute("validationCode");
        if(code.equals(enCode) && admin1!=null){
                session.setAttribute("success",admin1);
                return "redirect:/back/main/main.jsp";
        }else{
            return "redirect:/back/login.jsp";
        }
    }

    @RequestMapping("/editpwd")
    public @ResponseBody
    Map<String,Object> edit(Admin admin,HttpServletRequest request,String oldPassword){
        Map<String,Object> results=new HashMap<String,Object>();
        Admin admin1 = (Admin) request.getSession().getAttribute("success");
        String id = admin1.getId();
        if(oldPassword.equals(admin1.getPassword())){
            try {
                admin.setId(id);
                adminService.motify(admin);
                results.put("success",true);
            } catch (Exception e) {
                results.put("success",false);
                results.put("message",e.getMessage());
                e.printStackTrace();
            }
        }else {
            results.put("error","密码错误");
        }
        return results;
    }

    @RequestMapping("/loginOut")
    public String logOut(HttpServletRequest request){
        request.getSession().invalidate();
        return "redirect:/back/login.jsp";
    }
}
