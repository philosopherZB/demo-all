package com.philosopherzb.common.response;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * author: philosopherZB
 * date: 2020/8/21
 */
@Data
@Accessors(chain = true)
public class BizApiResponse implements Serializable {
    private static final long serialVersionUID = 1743635962617840834L;

    /**
     * 调用是否成功
     */
    private Boolean isSuccess;
    /**
     * 业务返回码
     */
    private String subResult;
    /**
     * 业务返回信息
     */
    private String subMessage;
    /**
     * 业务返回数据
     */
    private String bizContent;

    private BizApiResponse() {
    }

    /**
     * 返回一个成功的实例，业务数据请自行填充
     */
    public static BizApiResponse newSuccess() {
        BizApiResponse bizApiResponse = new BizApiResponse();
        bizApiResponse.setIsSuccess(true);
        bizApiResponse.setSubResult(BizApiResponseCode.SUCCESS.getCode());
        bizApiResponse.setSubMessage(BizApiResponseCode.SUCCESS.getMessage());
        return bizApiResponse;
    }

    /**
     * 返回一个失败的实例，业务数据请自行填充
     */
    public static BizApiResponse newFailure(BizApiResponseCode bizApiResponseCode) {
        BizApiResponse bizApiResponse = new BizApiResponse();
        bizApiResponse.setIsSuccess(false);
        bizApiResponse.setSubResult(bizApiResponseCode.getCode());
        bizApiResponse.setSubMessage(bizApiResponseCode.getMessage());
        return bizApiResponse;
    }
}
