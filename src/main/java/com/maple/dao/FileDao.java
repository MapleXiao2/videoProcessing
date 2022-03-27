package com.maple.dao;

import com.maple.pojo.PendingFile;
import com.maple.pojo.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface FileDao {
    int addFile(PendingFile pendingFile);

    List<String> getFiles(User user);
}
