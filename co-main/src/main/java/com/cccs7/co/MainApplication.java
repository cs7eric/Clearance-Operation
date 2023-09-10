package com.cccs7.co;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * <p> clearance-operation 启动类 </p>
 *
 * @Author cccs7/cs7eric - csq020611@gmail.com
 * @Description clearance-operation 启动类
 * @Date 2023/9/10 13:36
 */
@ComponentScan("com.cccs7")
@EnableWebMvc
@SpringBootApplication
public class MainApplication {
    public static void main(String[] args) {
        SpringApplication.run(MainApplication.class);
    }
}