package com.maple.controller.file;

import com.alibaba.fastjson.JSON;
import com.maple.pojo.User;
import com.maple.pojo.PendingFile;
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
import java.util.List;
import java.util.Map;
import java.util.Objects;

@RestController
public class PendingFileController {
    @Autowired
    FileService fileService;

    @RequestMapping("/uploadVideo")
    public Map<String, Object> upload(@RequestParam("file") MultipartFile file, HttpServletRequest request) {
        //返回Map给前端
        Map<String, Object> map = new HashMap<>();
        //暂时使用admin代替user
        User user = new User(1, "admin", "123456");

        //上传路径保存设置
        //String path = request.getServletContext().getRealPath("/upload");
        //System.out.println(path);
        String path = "D:\\upload\\".concat(user.getUserName()).concat("_").concat(user.getUserId().toString());
        if(Objects.requireNonNull(file.getContentType()).contains("image")){
            path = path.concat("\\images");
        }else if(Objects.requireNonNull(file.getContentType()).contains("video")){
            path = path.concat("\\videos");
        }
        File realPath = new File(path);
        if (!realPath.exists()) {
            realPath.mkdir();
        }

        try {
            //通过transferTo方法直接写文件
            file.transferTo(new File(realPath + "/" + file.getOriginalFilename()));

            PendingFile pendingFile = new PendingFile(file.getOriginalFilename(), realPath.toString(), user);
            if (!fileService.uploadNewFile(pendingFile)) {
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

    @RequestMapping("/getFiles")
    public String getFile() {
        //暂时使用admin代替user
        User user = new User(1, "admin", "123456");
        return JSON.toJSONString(fileService.getAllFiles(user));
    }

}
