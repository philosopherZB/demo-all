package com.philosopherzb.secret.service.web.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;

/**
 * @author philosopherZB
 * @date 2022/1/21
 */
@EqualsAndHashCode(callSuper = true)
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AppConfigRsaRequest extends PageRequest {
    private static final long serialVersionUID = 3346086615228744638L;
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
    @NotBlank(message = "tenantId 不能为空")
    private String tenantId;
    /**
     * 租户名称
     */
    @NotBlank(message = "tenantName 不能为空")
    private String tenantName;
    /**
     * 应用公钥，用于验签接口，同时加密AES秘钥
     */
    @NotBlank(message = "appPubKey 不能为空")
    private String appPubKey;

    /**
     * 删除标识，0-未删除，1-已删除
     */
    private Integer isDelete;
    /**
     * 伪随机码，生成规则：日期+雪花算法生成
     */
    private String randomNum;
    /**
     * 滑动窗口大小
     */
    @Max(value = 999, message = "encryptSlideSize 超过长度限制")
    private Integer encryptSlideSize;
    /**
     * 密文滑窗压缩长度
     */
    @Max(value = 999, message = "encryptIndexCompressLen 超过长度限制")
    private Integer encryptIndexCompressLen;
    /**
     * 过期时间，单位：天，默认90天
     */
    @Max(value = 999, message = "invalidTime 超过长度限制")
    private Integer invalidTime;
    /**
     * 最大有效期，单位：天，默认120天；必须大于invalidTime
     */
    @Max(value = 999, message = "maxInvalidTime 超过长度限制")
    private Integer maxInvalidTime;
}
