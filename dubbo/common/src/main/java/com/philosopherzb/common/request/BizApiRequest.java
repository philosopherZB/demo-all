package com.philosopherzb.common.request;

import lombok.Data;

import java.io.Serializable;

/**
 * author: philosopherZB
 * date: 2020/8/21
 */
@Data
public class BizApiRequest implements Serializable {
    private static final long serialVersionUID = -4807612807038027015L;

    /**
     * 机构分配的id
     */
    private String accessId;

    /**
     * 业务请求参数的Json字符串
     */
    private String bizContent;

    public BizApiRequest() {
    }

    public BizApiRequest(String accessId, String bizContent) {
        this.accessId = accessId;
        this.bizContent = bizContent;
    }
}
