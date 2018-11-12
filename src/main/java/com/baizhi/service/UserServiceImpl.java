package com.baizhi.service;

import com.baizhi.dao.UserDao;
import com.baizhi.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public void add(User user) {
        user.setId(UUID.randomUUID().toString().replace("-",""));
        userDao.insert(user);
    }

    @Override
    public void remove(String id) {

    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public User findOne(User user) {
        return userDao.queryOne(user);
    }

    @Override
    public void motify(User user) {
        userDao.update(user);
    }

    @Override
    public List<User> findAll() {
        return null;
    }

    @Override
    public List<User> findByPage(Integer page, Integer rows) {
        return null;
    }

    @Override
    public Long findTotals() {
        return null;
    }
}
