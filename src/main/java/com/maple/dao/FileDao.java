package com.maple.dao;

import com.maple.pojo.VideoFile;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface FileDao {
    int addFile(VideoFile videoFile);
}
