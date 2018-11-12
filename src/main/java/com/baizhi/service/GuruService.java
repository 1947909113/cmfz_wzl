package com.baizhi.service;

import com.baizhi.entity.Banner;
import com.baizhi.entity.Guru;

public interface GuruService extends BaseService<Guru> {

    Guru queryOne(String id);

}
