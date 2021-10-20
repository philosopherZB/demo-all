package com.philosopherzb.commonutil.minio;

import io.minio.MinioClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

/**
 * @author philosopherZB
 * @date 2021/4/2
 */
@Configuration
@ConfigurationProperties(prefix = "minio.config")
@Slf4j
public class MinIOUtils {
    /**
     * Accepts endpoint as a String, URL or okhttp3.HttpUrl object and optionally accepts port number and flag to enable secure (TLS) connection
     * s3服务器地址
     */
    private String endPoint;

    /**
     * Accepts access key (aka user ID) of an account in S3 service
     * 访问key
     */
    private String accessKey;

    /**
     * Accepts secret key (aka password) of an account in S3 service
     * 秘钥key
     */
    private String secretKey;

    /**
     * minIO客户端
     */
    private MinioClient minIoClient;

    @PostConstruct
    public void init() {
        log.info("====> minIoClient init <==== endPoint = {}", endPoint);
        minIoClient = MinioClient.builder()
                .endpoint(endPoint)
                .credentials(accessKey, secretKey)
                .build();
    }

    public String getEndPoint() {
        return endPoint;
    }

    public void setEndPoint(String endPoint) {
        this.endPoint = endPoint;
    }

    public String getAccessKey() {
        return accessKey;
    }

    public void setAccessKey(String accessKey) {
        this.accessKey = accessKey;
    }

    public String getSecretKey() {
        return secretKey;
    }

    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }

    public MinioClient getMinIoClient() {
        return minIoClient;
    }

    public void setMinIoClient(MinioClient minIoClient) {
        throw new UnsupportedOperationException("不支持此操作");
    }
}
