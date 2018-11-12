package com.baizhi.service;

import com.baizhi.dao.BannerDao;
import com.baizhi.entity.Banner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class BannerServiceImpl implements BannerService {

    @Autowired
    private BannerDao bannerDao;

    @Override
    public void add(Banner banner) {
        banner.setId(UUID.randomUUID().toString().replace("-",""));
        bannerDao.insert(banner);
    }

    @Override
    public void remove(String id) {
        bannerDao.delete(id);
    }

    @Override
    public Banner findOne(Banner banner) {
        return null;
    }

    @Override
    public void motify(Banner banner) {
        bannerDao.update(banner);
    }

    @Override
    public List findAll() {
        return null;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List findByPage(Integer page, Integer rows) {
        int start=(page-1)*rows;
        return bannerDao.queryByPage(start,rows);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public Long findTotals() {
        return bannerDao.queryTotals();
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public Banner queryOne(String id) {
        return bannerDao.findOne(id);
    }
}
