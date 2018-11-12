package com.baizhi.test;

import com.baizhi.dao.BannerDao;
import com.baizhi.entity.Banner;
import com.baizhi.service.BannerService;
import org.apache.ibatis.scripting.xmltags.ForEachSqlNode;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;
import java.util.UUID;

public class BannerTest extends BasicTest {

    @Autowired
    private BannerService bannerService;

    @Test
    public void queryAll() {
        List<Banner> byPage = bannerService.findByPage(1, 2);
        for (Banner banner : byPage) {
            System.out.println(banner);
        }
    }

    @Test
    public void save(){
        Banner banner = new Banner();
        banner.setId(UUID.randomUUID().toString());
        banner.setDescp("哈哈");
        banner.setStatus("y");
        banner.setTitle("测试3");
        banner.setDate(new Date());
        bannerService.add(banner);
    }


    @Test
    public void delete(){
        bannerService.remove("1");
    }

    @Test
    public void update(){
        Banner banner = new Banner();
        banner.setId("1");
        banner.setTitle("no");
        bannerService.motify(banner);
    }

    @Test
    public void findOne(){
        Banner banner = bannerService.queryOne("1");
        System.out.println(banner);
    }
}

