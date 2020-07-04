package com.whw.config;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * @program: hgshop
 * @ClassName FileUpdateController
 * @description:
 * @author: 吴宏伟
 * @create: 2020-01-10 16:15
 * @Version 1.0
 **/
@RestController
@CrossOrigin
public class FileUpdateController {

    @RequestMapping("/upload")
    public String upload(MultipartFile file) {
        try {
            //判断上传文件是否为空
            if (!file.isEmpty()) {
                //获取文件名称
                String originalFilename = file.getOriginalFilename();
                //定义长传后的文件名称
                String fileName = UUID.randomUUID() + "_" + originalFilename;
                //目标文件
                File distfile = new File("D:\\pic", fileName);
                //判断目标文件的父目录是否存在
                if (!distfile.getParentFile().exists()) {
                    //创建所有的目录
                    distfile.getParentFile().mkdirs();
                }
                file.transferTo(distfile);
                //返回结果
                String userface = "http://localhost:9000/" + fileName;
                //返回上传成功后的url地址
                return userface;
            }
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return null;
    }

}
