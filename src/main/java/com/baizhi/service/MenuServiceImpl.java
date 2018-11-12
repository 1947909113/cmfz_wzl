package com.baizhi.service;

import com.baizhi.dao.MenuDao;
import com.baizhi.entity.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class MenuServiceImpl implements MenuService {

    @Autowired
    private MenuDao menuDao;

    @Override
    public void add(Menu menu) {

    }

    @Override
    public void remove(String id) {

    }

    @Override
    public Menu findOne(Menu menu) {
        return null;
    }

    @Override
    public void motify(Menu menu) {
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<Menu> findAll() {
        return menuDao.queryAll();
    }

    @Override
    public List<Menu> findByPage(Integer page, Integer rows) {
        return null;
    }

    @Override
    public Long findTotals() {
        return null;
    }

}
