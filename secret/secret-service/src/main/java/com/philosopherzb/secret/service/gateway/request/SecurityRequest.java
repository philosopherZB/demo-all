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
public class SecurityRequest implements Serializable {
    private static final long serialVersionUID = 1360412415430494398L;

    /**
     * 秘钥版本号
     */
    private Long secretVersion;

    /**
     * 是否需要对结果进行加签
     */
    private Boolean verifyResponse;
}
