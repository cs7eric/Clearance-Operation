package com.cccs7.co.service.impl;

import com.cccs7.co.oss.AliOSSUtil;
import com.cccs7.co.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * <p> 文件服务接口实现类 </p>
 *
 * @Author cccs7/cs7eric - csq020611@gmail.com
 * @Description 文件服务接口实现类
 * @Date 2023/10/11 20:55
 */
@Service
public class FileServiceImpl implements FileService {

    @Autowired
    private AliOSSUtil aliOSSUtil;

    @Override
    public String uploadFile(MultipartFile file) {
        if (file.isEmpty()) {
            throw new IllegalArgumentException("文件为空");
        }

        try {
            return aliOSSUtil.upload(file);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
