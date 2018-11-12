package com.baizhi.service;

import com.baizhi.dao.AlbumDao;
import com.baizhi.entity.Album;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class AlbumServiceImpl implements AlbumService {

    @Autowired
    private AlbumDao albumDao;

    @Override
    public void add(Album album) {
        album.setId(UUID.randomUUID().toString().replace("-",""));
        albumDao.insert(album);
    }

    @Override
    public void remove(String id) {

    }

    @Override
    public Album findOne(Album album) {
        return null;
    }

    @Override
    public void motify(Album album) {

    }

    @Override
    public List<Album> findAll() {
        return null;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<Album> findByPage(Integer page, Integer rows) {
        int start=(page-1)*rows;
        return albumDao.queryByPage(start,rows);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public Long findTotals() {
        return albumDao.queryTotals();
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public Album findAlbum(String id) {
        return albumDao.albumShow(id);
    }
}
