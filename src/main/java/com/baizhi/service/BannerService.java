package com.baizhi.service;

import com.baizhi.entity.Banner;

public interface BannerService extends BaseService<Banner> {

    Banner queryOne(String id);

}
