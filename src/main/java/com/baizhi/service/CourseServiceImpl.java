package com.baizhi.service;

import com.baizhi.dao.CourseDao;
import com.baizhi.entity.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseDao courseDao;

    @Override
    public void add(Course course) {
        course.setId(UUID.randomUUID().toString().replace("-",""));
        courseDao.insert(course);
    }

    @Override
    public void remove(String id) {

    }

    @Override
    public Course findOne(Course course) {
        return null;
    }

    @Override
    public void motify(Course course) {

    }

    @Override
    public List<Course> findAll() {
        return null;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<Course> findByPage(Integer page, Integer rows) {
        int start=(page-1)*rows;
        return courseDao.queryByPage(start,rows);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public Long findTotals() {
        return courseDao.queryTotals();
    }
}
