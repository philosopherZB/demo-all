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
public class RsaVO implements Serializable {
    private static final long serialVersionUID = -4753773606559534685L;
    /**
     * 应用公钥，用于验签接口，同时加密AES秘钥
     */
    private String appPubKey;
    /**
     * 云服务私钥，云服务使用此私钥进行加签
     */
    private String dasPriKey;
    /**
     * 伪随机码，生成规则：日期+雪花算法生成
     */
    private String randomNum;
}
