package com.maple.controller.file;

import com.maple.pojo.User;
import com.maple.pojo.VideoFile;
import com.maple.service.file.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@RestController
public class UploadController {
    @Autowired
    FileService fileService;

    @RequestMapping("/uploadVideo")
    public Map<String, Object> uploadTest2(@RequestParam("file") MultipartFile file, HttpServletRequest request) {
        //返回Map给前端
        Map<String, Object> map = new HashMap<>();

        //上传路径保存设置
        String path = request.getServletContext().getRealPath("/upload");
        File realPath = new File(path);
        if (!realPath.exists()) {
            realPath.mkdir();
        }

        try {
            //通过transferTo方法直接写文件
            file.transferTo(new File(realPath + "/" + file.getOriginalFilename()));

            //暂时使用admin代替user
            User admin = new User(1, "admin", "123456");
            VideoFile videoFile = new VideoFile(file.getOriginalFilename(), realPath.toString(), admin);
            if (!fileService.uploadNewFile(videoFile)) {
                throw new IOException("文件" + file.getOriginalFilename() + "上传至数据库失败");
            }

            //同时用map记录参数
            map.put("msg", "ok");
            map.put("code", 200);

        } catch (IOException e) {
            map.put("msg", "error");
            map.put("code", 0);
            e.printStackTrace();
        }

        //return JSON.toJSONString(file);
        return map;

    }

}
