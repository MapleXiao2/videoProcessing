package com.maple;

import com.maple.pojo.User;
import com.maple.pojo.VideoFile;
import com.maple.service.file.FileService;
import com.maple.service.file.FileServiceImpl;
import com.maple.utils.SpringBeanUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;

@SpringBootTest
class VideoProcessingApplicationTests {

    @Autowired
    DataSource dataSource;

    @Test
    void contextLoads() {
        FileService fileService = (FileService) SpringBeanUtils.getBean("fileServiceImpl");
        //暂时使用admin代替user
        User admin = new User(1, "admin", "123456");
        VideoFile videoFile = new VideoFile("123.mp4", "132", admin);
        fileService.uploadNewFile(videoFile);

    }

}
