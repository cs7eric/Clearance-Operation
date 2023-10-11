package com.cccs7.co.oss;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.model.*;
import com.aliyuncs.exceptions.ServerException;
import com.cccs7.co.tool.UuidUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Component
@Scope("prototype")
@SuppressWarnings("all")
public class AliOSSUtil {


    private AliOSSProperties ACCOUNT ;

    public OSS ossClient;

    @Autowired
    public OSS oss(AliOSSProperties aliOSSProperties) {
        this.ACCOUNT = aliOSSProperties;
        String endpoint = ACCOUNT.getEndpoint(); // 获取阿里云 OSS 的访问域名
        String accessKeyId = ACCOUNT.getAccessKeyId(); // 获取访问阿里云 OSS 的 Access Key ID
        String accessKeySecret = ACCOUNT.getAccessKeySecret(); // 获取访问阿里云 OSS 的 Access Key Secret
        return ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret); // 创建 OSS 客户端实例
    }


    @Bean
    @Scope("prototype")
    public static OSS creatOss(AliOSSProperties config) {
        return  new OSSClientBuilder().build(config.getEndpoint(), config.getAccessKeyId(), config.getAccessKeySecret());
    }


    /**
     * 上传本地文件到阿里云 OSS
     *
     * @param sourceFilePathName 本地文件路径
     * @param aimFilePathName    目标文件路径
     * @return 上传后文件的访问 URL
     */
    public String upload(String sourceFilePathName, String aimFilePathName) {
        aimFilePathName = trimLeadingSlash(aimFilePathName); // 去除目标文件名前面的斜杠（如果存在）

        aimFilePathName = generateUniqueFileName(aimFilePathName); // 生成唯一的文件名

        PutObjectRequest putObjectRequest = new PutObjectRequest(ACCOUNT.getBucketName(), aimFilePathName, new File(sourceFilePathName)); // 创建上传文件的请求
        putObjectRequest.setMetadata(createObjectMetadata(aimFilePathName)); // 设置上传文件的元数据

        ossClient.putObject(putObjectRequest); // 执行文件上传到阿里云 OSS
        //关闭ossClient
        ossClient.shutdown();


        return "http://"+ACCOUNT.getBucketName()+"."+ACCOUNT.getEndpoint()+"/"+aimFilePathName; // 生成访问上传后文件的 URL，并返回
    }

    /**
     * 上传 MultipartFile 到阿里云 OSS
     *
     * @param multipartFile 上传的 MultipartFile
     * @return 上传后文件的访问 URL
     * @throws IOException 如果发生 I/O 错误
     */
    public String upload(MultipartFile multipartFile) throws IOException {

        this.ossClient = AliOSSUtil.creatOss(ACCOUNT);
        String uploadUrl=null;
        String original = multipartFile.getOriginalFilename(); // 获取上传文件的原始文件名
        String fileName = UuidUtils.getUuid();
        String substring = original.substring(original.lastIndexOf("."));
        String newfileName=fileName+substring;
        String datePath = new SimpleDateFormat("yyyy/MM/dd").format(new Date());//构建日期路径
        String filePath = datePath + "/"  +newfileName; // 构建文件在 OSS 中的存储路径
        PutObjectRequest putObjectRequest = new PutObjectRequest(ACCOUNT.getBucketName(), filePath, multipartFile.getInputStream()); // 创建上传文件的请求
        putObjectRequest.setMetadata(createObjectMetadata(filePath)); // 设置上传文件的元数据
        ossClient.putObject(putObjectRequest); // 执行文件上传到阿里云 OSS
        ossClient.shutdown();
        return "http://"+ACCOUNT.getBucketName()+"."+ACCOUNT.getEndpoint()+"/"+filePath; // 生成访问上传后文件的 URL，并返回
    }

    /**
     * 下载文件
     *
     * @param objectName 文件名
     * @return 文件的输入流
     */
    public InputStream download(String objectName) {
        objectName = trimLeadingSlash(objectName); // 去除文件名前面的斜杠（如果存在）

        GetObjectRequest getObjectRequest = new GetObjectRequest(ACCOUNT.getBucketName(), objectName); // 创建下载文件的请求

        OSSObject ossObject = ossClient.getObject(getObjectRequest); // 获取文件对象

        return ossObject.getObjectContent(); // 返回文件的输入流
    }

    /**
     * 删除文件
     *
     * @param objectName 文件名
     */
    public void delete(String objectName) {
        objectName = trimLeadingSlash(objectName); // 去除文件名前面的斜杠（如果存在）

        ossClient.deleteObject(ACCOUNT.getBucketName(), objectName); // 删除文件
    }

    /**
     * 列举文件
     *
     * @param prefix 文件名前缀
     * @return 文件名列表
     */
    public List<String> listObjects(String prefix) {
        ListObjectsRequest request = new ListObjectsRequest(ACCOUNT.getBucketName()); // 创建列举文件的请求
        request.setPrefix(prefix); // 设置文件名前缀

        ObjectListing listing = ossClient.listObjects(request); // 获取文件列表

        return listing.getObjectSummaries().stream()
                .map(OSSObjectSummary::getKey)
                .collect(Collectors.toList()); // 将文件名收集到列表中并返回
    }

    /**
     * 创建文件的元数据对象
     *
     * @param fileName 文件名
     * @return 文件的元数据对象
     */
    private ObjectMetadata createObjectMetadata(String fileName) {
        ObjectMetadata metadata = new ObjectMetadata(); // 创建文件元数据对象

        String contentType = getContentType(fileName); // 获取文件的 Content-Type
        metadata.setContentType(contentType); // 设置文件的 Content-Type

        return metadata;
    }

    /**
     * 生成预签名 URL
     *
     * @param objectName 文件名
     * @return 预签名 URL
     */
    private URL generatePresignedUrl(String objectName) {
        Date expiration = new Date(System.currentTimeMillis() + 3600L * 1000 * 24 * 365 * 100);
        return ossClient.generatePresignedUrl(ACCOUNT.getBucketName(), objectName,expiration);
    }

    /**
     * 生成唯一的文件名
     *
     * @param fileName 原始文件名
     * @return 唯一的文件名
     */
    private String generateUniqueFileName(String fileName) {
        return DateTimeFormatter.ISO_DATE.format(LocalDate.now()) + "/" + fileName; // 生成唯一的文件名，包含日期和原始文件名
    }

    /**
     * 去除路径前面的斜杠
     *
     * @param path 路径
     * @return 去除斜杠后的路径
     */
    private String trimLeadingSlash(String path) {
        return path.startsWith("/") ? path.substring(1) : path; // 如果路径以斜杠开头，则去除开头的斜杠
    }

    /**
     * 获取文件的 Content-Type
     *
     * @param fileName 文件名
     * @return 文件的 Content-Type
     */
    private String getContentType(String fileName) {
        // 根据文件名的后缀判断 Content-Type
        if (fileName.endsWith(".png")) {
            return "image/png";
        } else if (fileName.endsWith(".jpg") || fileName.endsWith(".jpeg")) {
            return "image/jpeg";
        } else if (fileName.endsWith(".gif")) {
            return "image/gif";
        } else if (fileName.endsWith(".bmp")) {
            return "image/bmp";
        } else if (fileName.endsWith(".txt")) {
            return "text/plain";
        } else if (fileName.endsWith(".pdf")) {
            return "application/pdf";
        } else if (fileName.endsWith(".doc") || fileName.endsWith(".docx")) {
            return "application/msword";
        } else if (fileName.endsWith(".xls") || fileName.endsWith(".xlsx")) {
            return "application/vnd.ms-excel";
        } else if (fileName.endsWith(".ppt") || fileName.endsWith(".pptx")) {
            return "application/vnd.ms-powerpoint";
        } else if (fileName.endsWith(".zip")) {
            return "application/zip";
        } else if (fileName.endsWith(".rar")) {
            return "application/x-rar-compressed";
        } else {
            return "application/octet-stream";
        }
    }

    /**
     * 当Bucket不存在时创建Bucket
     *
     * @throws OSSException 异常
     *  Bucket命名规则：
     *  1.只能包含小写字母、数字和短横线，
     *  2.必须以小写字母和数字开头和结尾
     *  3.长度在3-63之间
     */
    private  void createBucket() throws ServerException {
        try {
            if (!ossClient.doesBucketExist(ACCOUNT.getBucketName())) {//判断是否存在该Bucket，不存在时再重新创建
                ossClient.createBucket(ACCOUNT.getBucketName());
            }
        } catch (Exception e) {
            log.error("{}", "创建Bucket失败,请核对Bucket名称(规则：只能包含小写字母、数字和短横线，必须以小写字母和数字开头和结尾，长度在3-63之间)");
            throw new ServerException("500", "错误");
        }
    }
}
