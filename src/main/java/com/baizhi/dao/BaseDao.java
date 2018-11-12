package com.baizhi.dao;

import com.baizhi.entity.Banner;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BaseDao<T> {

    void insert(T t);

    void delete(String id);

    T queryOne(T t);

    void update(T t);

    List<T> queryAll();

    /*分页*/
    List<T> queryByPage(@Param("start") Integer start, @Param("rows") Integer rows);

    Long queryTotals();

}
