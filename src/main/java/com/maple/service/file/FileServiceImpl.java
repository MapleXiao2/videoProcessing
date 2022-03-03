package com.maple.service.file;

import com.maple.dao.FileDao;
import com.maple.pojo.VideoFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FileServiceImpl implements FileService {
    @Autowired
    private FileDao fileDao;

    @Override
    public boolean uploadNewFile(VideoFile videoFile) {
        int re = fileDao.addFile(videoFile);
        return re > 0;
    }
}
