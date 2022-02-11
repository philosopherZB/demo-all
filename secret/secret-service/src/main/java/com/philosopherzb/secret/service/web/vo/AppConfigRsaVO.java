package com.philosopherzb.secret.service.web.vo;

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
public class AppConfigRsaVO implements Serializable {
    private static final long serialVersionUID = -5657302186062835563L;

    /**
     * 自增主键
     */
    private Long id;
    /**
     * 应用id，用于唯一标识应用；生成规则：云服务前缀+雪花算法生成
     */
    private String appId;
    /**
     * 租户id
     */
    private String tenantId;
    /**
     * 租户名称
     */
    private String tenantName;
    /**
     * 应用公钥，用于验签接口，同时加密AES秘钥
     */
    private String appPubKey;
    /**
     * 云服务公钥，用于接入方验签
     */
    private String dasPubKey;
    /**
     * 滑动窗口大小
     */
    private Integer encryptSlideSize;
    /**
     * 密文滑窗压缩长度
     */
    private Integer encryptIndexCompressLen;
    /**
     * 伪随机码，生成规则：日期+雪花算法生成
     */
    private String randomNum;
    /**
     * 过期时间，单位：天，默认90天
     */
    private Integer invalidTime;
    /**
     * 最大有效期，单位：天，默认120天；必须大于invalidTime
     */
    private Integer maxInvalidTime;
    /**
     * 删除标识，0-未删除，1-已删除
     */
    private Integer isDelete;
    /**
     * 创建时间
     */
    private String createTime;
    /**
     * 修改时间
     */
    private String modifyTime;
}
