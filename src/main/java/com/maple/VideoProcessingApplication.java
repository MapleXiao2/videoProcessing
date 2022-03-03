package com.maple;

import com.maple.utils.SpringBeanUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;


@SpringBootApplication
public class VideoProcessingApplication {

    public static void main(String[] args) {
        ApplicationContext applicationContext = SpringApplication.run(VideoProcessingApplication.class, args);
        SpringBeanUtils.setApplicationContext(applicationContext);
    }

}
