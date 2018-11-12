package com.baizhi.controller;
import com.baizhi.entity.Course;
import com.baizhi.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/course")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @RequestMapping("/findAll")
    public @ResponseBody
    Map<String,Object> findAll(Integer page, Integer rows){
        Map<String,Object> results = new HashMap<String,Object>();
        //当前页数据rows:
        List<Course> byPage = courseService.findByPage(page, rows);
        //总记录数
        Long totals = courseService.findTotals();
        results.put("total",totals);
        results.put("rows",byPage);
        return results;
    }

    @RequestMapping("/save")
    public @ResponseBody
    Map<String,Object> save(Course course){
        Map<String,Object> results=new HashMap<String,Object>();
        try {
            courseService.add(course);
            results.put("success",true);
        }catch (Exception e){
            e.printStackTrace();
            results.put("success",false);
            results.put("message",e.getMessage());
        }
        return results;
    }
}
