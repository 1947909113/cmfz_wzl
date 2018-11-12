package com.baizhi.service;

import com.baizhi.dao.ChapterDao;
import com.baizhi.entity.Chapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class ChapterServiceImpl implements ChapterService {

    @Autowired
    private ChapterDao chapterDao;

    @Override
    public void add(Chapter chapter) {
        chapter.setId(UUID.randomUUID().toString().replace("-",""));
        chapterDao.insert(chapter);
    }

    @Override
    public void remove(String id) {

    }

    @Override
    public Chapter findOne(Chapter chapter) {
        return null;
    }

    @Override
    public void motify(Chapter chapter) {

    }

    @Override
    public List<Chapter> findAll() {
        return null;
    }

    @Override
    public List<Chapter> findByPage(Integer page, Integer rows) {
        return null;
    }

    @Override
    public Long findTotals() {
        return null;
    }
}
