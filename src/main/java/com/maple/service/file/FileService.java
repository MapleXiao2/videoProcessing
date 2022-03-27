package com.maple.service.file;


import com.maple.pojo.PendingFile;
import com.maple.pojo.User;

import java.util.List;


public interface FileService {
    boolean uploadNewFile(PendingFile pendingFile);

    List<String> getAllFiles(User user);
}
