package com.philosopherzb.secret.service.gateway.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.io.Serializable;

/**
 * @author philosopherZB
 * @date 2022/2/8
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiRequest implements Serializable {
    private static final long serialVersionUID = 5215705281428854627L;

    /**
     * 应用id
     */
    private String appId;
    /**
     * 伪随机码
     */
    private String randomNum;
    /**
     * 时间戳
     */
    private Long timestamp;
    /**
     * 字符集
     */
    private String charset;
    /**
     * 签名串
     */
    private String sign;
    /**
     * 业务内容
     */
    private String bizContent;
}
