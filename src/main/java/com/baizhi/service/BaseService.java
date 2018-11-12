package com.baizhi.service;

import com.baizhi.entity.Banner;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BaseService<T> {

    void add(T t);

    void remove(String id);

    T findOne(T t);

    void motify(T t);

    List<T> findAll();

    /*分页*/
    List<T> findByPage(Integer page, Integer rows);

    Long findTotals();

}
