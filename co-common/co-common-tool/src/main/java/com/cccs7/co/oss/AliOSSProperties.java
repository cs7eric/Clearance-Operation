package com.cccs7.co.oss;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;


/**
 * <p> 阿里云oss属性 </p>
 *
 * @Author cccs7/cs7eric - csq020611@gmail.com
 * @Description 阿里云oss属性
 * @Date 2023/10/11 19:53
 */
@Data
@Component
@ConfigurationProperties(prefix = "co.aliyun.oss")
public class AliOSSProperties {

    private String accessKeyId;

    private String accessKeySecret;

    private String bucketName;

    private String endpoint;

}
