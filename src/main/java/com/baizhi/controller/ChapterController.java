package com.baizhi.controller;

import com.baizhi.entity.Album;
import com.baizhi.entity.Chapter;
import com.baizhi.service.ChapterService;
import org.apache.commons.io.IOUtils;
import org.jaudiotagger.audio.AudioFileIO;
import org.jaudiotagger.audio.mp3.MP3AudioHeader;
import org.jaudiotagger.audio.mp3.MP3File;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/chapter")
public class ChapterController {

    @Autowired
    private ChapterService chapterService;

    @RequestMapping("/save")
    public @ResponseBody
    Map<String,Object> save(Chapter chapter, HttpServletRequest request, MultipartFile name,String parent_id){
        Map<String,Object> results=new HashMap<String,Object>();
        String originalFilename = name.getOriginalFilename();
        String realPath = request.getSession().getServletContext().getRealPath("/back/album/music");
        try {
            File file=new File(realPath,originalFilename);
            name.transferTo(file);
            //上传
            MP3File mp3 = (MP3File)AudioFileIO.read(file);
            MP3AudioHeader audioHeader = (MP3AudioHeader)mp3.getAudioHeader();
            int trackLength = audioHeader.getTrackLength();

            chapter.setDownPath("/back/album/music/"+originalFilename);
            double size = (double)name.getSize();
            chapter.setSize(size);
            chapter.setDuration(trackLength+"秒");
            Album album = new Album();
            album.setId(parent_id);
            chapter.setAlbum(album);
            chapterService.add(chapter);
            results.put("success","添加成功");
            return results;
        } catch (Exception e) {
            e.printStackTrace();
            results.put("message",e.getMessage());
            results.put("error","添加失败");

        }
        return results;

    }

    //音频下载
    @RequestMapping("/downLoad")
    public @ResponseBody Map<String,Object> downLoad(String openStyle, HttpServletRequest request, HttpServletResponse response, String downPath) {
        Map<String, Object> map = new HashMap<String,Object>();
        String[] split = downPath.split("/");
        String fileName=split[4];
        try {
            //1.根据接收的文件名去服务中指定目录读取文件
            String realPath = request.getSession().getServletContext().getRealPath("/back/album/music");
            //2.以文件输入流读取文件
            FileInputStream is = new FileInputStream(new File(realPath,fileName));
            //2.1 设置响应头
            response.setHeader("content-disposition", openStyle+";fileName="+URLEncoder.encode(fileName, "UTF-8"));
            //3.获取响应输出流
            ServletOutputStream os = response.getOutputStream();
            //4.使用IOUtils工具类
            IOUtils.copy(is, os);
            //5.关流
            IOUtils.closeQuietly(is);//安静关流
            IOUtils.closeQuietly(os);
            map.put("success","下载成功");
            return map;
        } catch (IOException e) {
            e.printStackTrace();
            map.put("message",e.getMessage());
            map.put("error","下载失败");
        }
        return map;
    }
}
