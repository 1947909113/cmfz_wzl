package com.baizhi.test;

import com.baizhi.entity.Banner;
import com.baizhi.entity.Chapter;
import com.baizhi.service.BannerService;
import com.baizhi.service.ChapterService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;
import java.util.UUID;

public class ChapterTest extends BasicTest {

    @Autowired
    private ChapterService chapterService;

    @Test
    public void save(){
        Chapter chapter = new Chapter();
        chapter.setId("2");
        chapter.setSize(20.0);
        chapter.setTitle("lala");
        chapterService.add(chapter);
    }
}

