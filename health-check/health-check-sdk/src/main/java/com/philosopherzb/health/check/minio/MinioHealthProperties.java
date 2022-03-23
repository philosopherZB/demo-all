package com.philosopherzb.health.check.minio;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author philosopherZB
 * @date 2022/3/22
 */
@Data
@ConfigurationProperties(prefix = "health.check.minio")
public class MinioHealthProperties {
    /**
     * 是否启动minio健康监测
     * 可选值：true & false
     * 默认 false
     */
    private String enabled = "false";
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
     * 文件名
     * 格式：{project-name}-health-check
     */
    private String fineName = "minio-default-health-check";
}
