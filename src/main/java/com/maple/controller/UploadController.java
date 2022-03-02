package com.maple.controller;

import com.alibaba.fastjson.JSON;
import org.springframework.stereotype.Controller;
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

    @RequestMapping("/uploadVideo")
    public Map<String, Object> uploadTest2(@RequestParam("file") MultipartFile file, HttpServletRequest request){
        //返回Map给前端
        Map<String, Object> map = new HashMap<>();

        //传入的文件名
        System.out.println(file.getOriginalFilename());

        //上传路径保存设置
        String path = request.getServletContext().getRealPath("/upload");
        File realPath = new File(path);
        if(!realPath.exists()){
            realPath.mkdir();
        }

        //上传文件地址
        System.out.println("上传文件保存地址：" + realPath);

        //通过transferTo方法直接写文件,同时用map记录参数
        try {
            file.transferTo(new File(realPath + "/" + file.getOriginalFilename()));
            map.put("msg","ok");
            map.put("code",200);
        } catch (IOException e) {
            map.put("msg","error");
            map.put("code",0);
            e.printStackTrace();
        }

        //return JSON.toJSONString(file);
        return map;

    }
}
