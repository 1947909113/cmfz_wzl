package com.baizhi.dao;

import com.baizhi.entity.Album;

public interface AlbumDao extends BaseDao<Album> {

    Album albumShow(String id);

}
