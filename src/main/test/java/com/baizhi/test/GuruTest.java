package com.baizhi.test;

import com.baizhi.entity.Banner;
import com.baizhi.entity.Guru;
import com.baizhi.service.BannerService;
import com.baizhi.service.GuruService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;
import java.util.UUID;

public class GuruTest extends BasicTest {

    @Autowired
    private GuruService guruService;

    @Test
    public void queryAll() {
        List<Guru> byPage = guruService.findByPage(1, 2);
        for (Guru guru : byPage) {
            System.out.println(guru);
        }
    }

   @Test
    public void save(){
       Guru guru = new Guru();
       guru.setName("haha");
       guru.setSex("男");
       guruService.add(guru);
   }


    @Test
    public void delete(){
        guruService.remove("1");
    }

    @Test
    public void update(){
        Guru guru = new Guru();
        guru.setId("1");
        guru.setName("haha");
        guruService.motify(guru);
    }

    @Test
    public void findOne(){
        Guru guru = guruService.queryOne("1");
        System.out.println(guru);
    }
}

