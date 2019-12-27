package com.philosopherzb.springaop.dto;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * author: philosopherZB
 * date: 2019/12/25
 */
@Data
public class ApiRequest implements Serializable {
    private static final long serialVersionUID = 2326994737417843497L;

    @JsonProperty(value = "access_id")
    @JSONField(name = "access_id")
    private String accessId;

    private String version;

    private String method;

    @JsonProperty(value = "biz_content")
    @JSONField(name = "biz_content")
    private String bizContent;
}
