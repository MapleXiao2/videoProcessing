package com.maple.configuration.file;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.maple.pojo")
@ComponentScan("com.maple.dao")
public class FileConfiguration {
}
