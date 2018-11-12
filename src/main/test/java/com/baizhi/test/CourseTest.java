package com.baizhi.test;

import com.baizhi.entity.Album;
import com.baizhi.entity.Course;
import com.baizhi.service.AlbumService;
import com.baizhi.service.CourseService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

public class CourseTest extends BasicTest {

    @Autowired
    private CourseService courseService;

    @Test
    public void queryAll() {
        List<Course> byPage = courseService.findByPage(1, 2);
        Long totals = courseService.findTotals();
        System.out.println(totals);
        for (Course course : byPage) {
            System.out.println(course);
        }
    }

    @Test
    public void save(){
        Course course = new Course();
        course.setId("3");
        course.setTitle("诚心礼佛");
        course.setFlag("必修");
        course.setCreatTime(new Date());
        courseService.add(course);
    }
}

