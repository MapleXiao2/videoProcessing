package com.maple.service.file;

import com.maple.dao.FileDao;
import com.maple.pojo.PendingFile;
import com.maple.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FileServiceImpl implements FileService {
    @Autowired
    private FileDao fileDao;

    @Override
    public boolean uploadNewFile(PendingFile pendingFile) {
        int re = fileDao.addFile(pendingFile);
        return re > 0;
    }

    @Override
    public List<String> getAllFiles(User user) {

        return fileDao.getFiles(user);
    }
}
