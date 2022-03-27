package com.maple;

import com.alibaba.fastjson.JSON;
import com.maple.pojo.FileInformation;
import com.maple.pojo.User;
import com.maple.pojo.PendingFile;
import com.maple.service.file.FileService;
import com.maple.utils.SpringBeanUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.util.List;

@SpringBootTest
class VideoProcessingApplicationTests {

    @Autowired
    DataSource dataSource;

    @Test
    void contextLoads() {
        FileService fileService = (FileService) SpringBeanUtils.getBean("fileServiceImpl");
        //暂时使用admin代替user
        User admin = new User(1, "admin", "123456");
        List<String> allFiles = fileService.getAllFiles(admin);
        System.out.println(allFiles);

    }

    @Test
    public String pyfileUpload() {
        String result = "";
        try {
            //这个方法是类似隐形开启了命令执行器，输入指令执行python脚本
            Process process = Runtime.getRuntime()
                    .exec("python解释器位置（这里一定要用python解释器所在位置不要用python这个指令）+ python脚本所在路径（一定绝对路径）");
            //这种方式获取返回值的方式是需要用python打印输出，然后java去获取命令行的输出，在java返回
            InputStreamReader ir = new InputStreamReader(process.getInputStream());
            LineNumberReader input = new LineNumberReader(ir);
            result = input.readLine();//中文的话这里可能会有乱码，可以尝试转一下不过问题不大
//            result1 = new String(result.getBytes("iso8859-1"),"utf-8");
            input.close();
            ir.close();
            int re = process.waitFor();
            System.out.println(result);
        } catch (IOException | InterruptedException e) {
            System.out.println("调用python脚本并读取结果时出错：" + e.getMessage());
        }
        return result;
    }

    @Test
    public void createJsonAndPy(){
        String[] videos = {"D:\\upload\\admin_1\\videos\\周杰伦-说好不哭 (with 五月天阿信)(蓝光).mp4"};
        String images = "D:\\upload\\admin_1\\images";
        FileInformation fileInformation = new FileInformation(videos, images);
        String s = JSON.toJSONString(fileInformation);
        System.out.println(s);
    }
}
