package com.baizhi.controller;

import com.baizhi.entity.Album;
import com.baizhi.entity.Chapter;
import com.baizhi.service.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/album")
public class AlbumController {

    @Autowired
    private AlbumService albumService;

    @RequestMapping("/findAll")
    public @ResponseBody Map<String,Object> findAll(Integer page, Integer rows){
        Map<String,Object> results = new HashMap<String,Object>();
        //当前页数据rows:
        List<Album> albums = albumService.findByPage(page, rows);
        //总记录数
        Long totals = albumService.findTotals();
        results.put("total",totals);
        results.put("rows",albums);
        return results;
    }

    @RequestMapping("/save")
    public @ResponseBody
    Map<String,Object> save(Album album){
        Map<String,Object> results=new HashMap<String,Object>();
        try {
            albumService.add(album);
            results.put("success",true);
        }catch (Exception e){
            e.printStackTrace();
            results.put("success",false);
            results.put("message",e.getMessage());
        }
        return results;
    }

    @RequestMapping("/showalbum")
    public @ResponseBody Album showalbum(String id){
        return albumService.findAlbum(id);
    }
}
