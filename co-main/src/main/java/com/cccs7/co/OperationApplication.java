package com.cccs7.co;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * <p> ClearanceOperation springboot  启动类 </p>
 *
 * @Author cccs7/cs7eric - csq020611@gmail.com
 * @Description ClearanceOperation springboot  启动类
 * @Date 2023/9/8 13:39
 */
@SpringBootApplication
@ComponentScan("com.cccs7.*")
public class OperationApplication {

    public static void main(String[] args) {

        SpringApplication.run(OperationApplication.class);
    }
}
