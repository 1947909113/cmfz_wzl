package com.baizhi.test;

import com.baizhi.entity.Album;
import com.baizhi.entity.Banner;
import com.baizhi.service.AlbumService;
import com.baizhi.service.BannerService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;
import java.util.UUID;

public class AlbumTest extends BasicTest {

    @Autowired
    private AlbumService albumService;

    @Test
    public void queryAll() {
        List<Album> byPage = albumService.findByPage(1,2);
        Long totals = albumService.findTotals();
        System.out.println(totals);
        for (Album album : byPage) {
            System.out.println(album);
        }
    }

    @Test
    public void save(){
        Album album = new Album();
        album.setId("1");
        album.setTitle("音乐");
        albumService.add(album);
    }

    @Test
    public void findAlbum(){
        Album album = albumService.findAlbum("1");
        System.out.println(album);
    }
}

