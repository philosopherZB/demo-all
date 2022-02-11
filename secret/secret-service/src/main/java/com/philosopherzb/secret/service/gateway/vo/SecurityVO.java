package com.philosopherzb.secret.service.gateway.vo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.io.Serializable;

/**
 * @author philosopherZB
 * @date 2022/1/21
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SecurityVO implements Serializable {
    private static final long serialVersionUID = 3941421202695586777L;
    /**
     * 应用id，用于唯一标识应用；生成规则：云服务前缀+雪花算法生成
     */
    private String appId;
    /**
     * aes秘钥,固定长度
     */
    private String aesKey;
    /**
     * 滑动窗口大小
     */
    private Integer encryptSlideSize;
    /**
     * 密文滑窗压缩长度
     */
    private Integer encryptIndexCompressLen;
    /**
     * 过期时间，单位：天，默认90天
     */
    private Integer invalidTime;
    /**
     * 最大有效期，单位：天，默认120天；必须大于invalidTime
     */
    private Integer maxInvalidTime;

    /**
     * 响应结果签名值
     */
    private String sign;
}
