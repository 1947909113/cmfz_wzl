package com.baizhi.controller;

import com.baizhi.entity.Banner;
import com.baizhi.service.BannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/banner")
public class BannerController {

    @Autowired
    private BannerService bannerService;

    @RequestMapping("/findAll")
    public @ResponseBody
    Map<String,Object> findAll(Integer page, Integer rows){
        Map<String,Object> results = new HashMap<String,Object>();
        //当前页数据rows:
        List<Banner> banners = bannerService.findByPage(page, rows);
        //总记录数
        Long totals = bannerService.findTotals();
        results.put("total",totals);
        results.put("rows",banners);
        return results;
    }

    @RequestMapping("/save")
    public @ResponseBody Map<String,Object> save(Banner banner, MultipartFile img, HttpServletRequest request){
        Map<String,Object> results=new HashMap<String,Object>();
        String of = img.getOriginalFilename();
        String realPath = request.getSession().getServletContext().getRealPath("/files/");
        try {
            //上传
            img.transferTo(new File(realPath,of));
            banner.setImgPath("/files/"+of);
            bannerService.add(banner);
            results.put("success",true);
        }catch (Exception e){
            e.printStackTrace();
            results.put("success",false);
            results.put("message",e.getMessage());
        }
        return results;
    }

    @RequestMapping("/delAll")
    public @ResponseBody Map<String,Object> delAll(String [] id){
        Map<String,Object> results=new HashMap<String,Object>();
        try {
            for (int i=0;i<id.length;i++){
                bannerService.remove(id[i]);
            }
            results.put("success",true);
        }catch (Exception e){
            e.printStackTrace();
            results.put("success",false);
            results.put("message",e.getMessage());
        }
        return results;
    }

    @RequestMapping("/edit")
    public @ResponseBody Map<String,Object> edit(Banner banner, MultipartFile img, HttpServletRequest request){
        Map<String,Object> results=new HashMap<String,Object>();
        String of = img.getOriginalFilename();
        String realPath = request.getSession().getServletContext().getRealPath("/files/");
        try {
            img.transferTo(new File(realPath,of));
            banner.setImgPath("/files/"+of);
            bannerService.motify(banner);
            results.put("success",true);
        }catch (Exception e){
            e.printStackTrace();
            results.put("success",false);
            results.put("message",e.getMessage());
        }
        return results;
    }

    @RequestMapping("/findOne")
    public @ResponseBody Banner findOne(String id){
        Banner banner = bannerService.queryOne(id);
        return banner;
    }
}
