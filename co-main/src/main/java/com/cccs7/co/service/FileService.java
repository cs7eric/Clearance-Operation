package com.cccs7.co.service;

import org.springframework.web.multipart.MultipartFile;

/**
 * <p> 文件服务接口 </p>
 *
 * @Author cccs7/cs7eric - csq020611@gmail.com
 * @Description 文件服务接口
 * @Date 2023/10/11 20:55
 */
public interface FileService {

    /**
     * 上传文件
     *
     * @param file 文件
     * @return {@link String}
     */
    String uploadFile(MultipartFile file);
}
