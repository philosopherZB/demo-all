package com.philosopherzb.secret.service.web.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotBlank;

/**
 * @author philosopherZB
 * @date 2022/1/21
 */
@EqualsAndHashCode(callSuper = true)
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AppConfigAesRequest extends PageRequest {
    private static final long serialVersionUID = 4022451235683388737L;

    /**
     * 应用id，用于唯一标识应用；生成规则：云服务前缀+雪花算法生成
     */
    @NotBlank(message = "appId 不能为空")
    private String appId;
    /**
     * 版本号，用于升级aesKey
     */
    private Long secretVersion;
    /**
     * 删除标识，0-未删除，1-已删除
     */
    private Integer isDelete;
}
