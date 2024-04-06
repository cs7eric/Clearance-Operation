package com.cccs7.co.controller;

import com.cccs7.co.encrypt.EncryptUtil;
import com.cccs7.co.service.FileService;
import com.cccs7.co.service.MailService;
import com.cccs7.web.bean.PageResponse;
import com.cccs7.web.bean.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

/**
 * <p> 公共接口服务 </p>
 *
 * @Author cccs7/cs7eric - csq020611@gmail.com
 * @Description 公共接口服务
 * @Date 2023/10/1 15:11
 */
@RestController
@RequestMapping("/common")
public class CommonController {

    @Autowired
    private MailService mailService;

    @Autowired
    private FileService fileService;

    @Autowired
    private EncryptUtil encryptUtil;

    /**
     * 发送邮箱服务验证码
     *
     * @param email 用户邮箱
     * @return {@link Result}<{@link String}>
     */
    @PostMapping("/sendCode")
    public Result<String> sendCode(@RequestParam String email) {
        mailService.sendMailMessage(email);
        return Result.ok("发送成功");
    }

    @PostMapping("/upload")
    public Result<String> upload(@RequestParam("file") MultipartFile file) {

        String fileUrl = fileService.uploadFile(file);
        return Result.ok(fileUrl);
    }

    @GetMapping("/encrypt")
    public Result<String> encrypt(@RequestParam("content") String content) {
        String encrypted = encryptUtil.encrypt(content);
        return Result.ok(encrypted);
    }

}
