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
public class AppConfigAesVO implements Serializable {
    private static final long serialVersionUID = 2828281223234289693L;
    /**
     * 自增主键
     */
    private Long id;
    /**
     * 应用id，用于唯一标识应用；生成规则：云服务前缀+雪花算法生成
     */
    private String appId;
    /**
     * 版本号，用于升级aesKey
     */
    private Long secretVersion;
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
