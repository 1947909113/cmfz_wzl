package com.baizhi.service;

import com.baizhi.dao.AdminDao;
import com.baizhi.entity.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class AdminServiceImpl implements AdminService{

    @Autowired
    private AdminDao adminDao;

    @Override
    public void add(Admin admin) {

    }

    @Override
    public void remove(String id) {

    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public Admin findOne(Admin admin) {

        return adminDao.queryOne(admin);
    }

    @Override
    public void motify(Admin admin) {
        adminDao.update(admin);
    }
    @Override
    public List<Admin> findAll() {
        return null;
    }

    @Override
    public List<Admin> findByPage(Integer page, Integer rows) {
        return null;
    }

    @Override
    public Long findTotals() {
        return null;
    }

}
