package com.philosopherzb.common.response;

import lombok.Data;
import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;
import java.util.UUID;

/**
 * author: philosopherZB
 * date: 2020/8/21
 */
@Data
public class GateWayApiResponse implements Serializable {
    private static final long serialVersionUID = -9077872995128490225L;

    /**
     * 唯一标识码，uuid
     */
    private String requestId;

    /**
     * 返回码
     */
    private String result;

    /**
     * 返回消息
     */
    private String message;

    /**
     * 业务子系统返回码
     */
    private String subResult;

    /**
     * 业务子系统返回消息
     */
    private String subMessage;

    /**
     * 业务数据
     */
    private String bizContent;

    /**
     * 构造器，返回requestId
     */
    private GateWayApiResponse() {
        if (StringUtils.isEmpty(requestId)) {
            requestId = UUID.randomUUID().toString();
        }
    }

    /**
     * 根据基本状态码构造返回对象
     *
     * @param responseCode 状态码
     */
    private GateWayApiResponse(GateWayApiResponseCode responseCode) {
        this();
        this.result = responseCode.getCode();
        this.message = responseCode.getMessage();
    }


    /**
     * 创建一个成功返回,返回数据自行填充
     */
    public static GateWayApiResponse newSuccess() {
        return new GateWayApiResponse(GateWayApiResponseCode.SUCCESS);
    }

    /**
     * 创建一个失败返回,返回数据自行填充
     *
     * @param gateWayApiResponseCode 状态码
     */
    public static GateWayApiResponse newFailure(GateWayApiResponseCode gateWayApiResponseCode) {
        if (gateWayApiResponseCode == null) {
            throw new IllegalArgumentException("gateWayApiResponseCode is null");
        }
        return new GateWayApiResponse(gateWayApiResponseCode);
    }

    /**
     * 将业务系统返回参数包装成网关返回参数
     *
     * @param bizApiResponse 业务系统的返回参数
     * @return 网关系统的返回参数
     */
    public static GateWayApiResponse loadFromBizResponse(BizApiResponse bizApiResponse) {
        if (bizApiResponse == null) {
            throw new IllegalArgumentException("loadFromBizResponse failed, bizApiResponse null");
        }
        GateWayApiResponse gateWayApiResponse;
        if (bizApiResponse.getIsSuccess()) {
            gateWayApiResponse = newSuccess();
        } else {
            gateWayApiResponse = newFailure(GateWayApiResponseCode.BIZ_SYSTEM_RETURN_ERROR);
        }
        gateWayApiResponse.setSubResult(bizApiResponse.getSubResult());
        gateWayApiResponse.setSubMessage(bizApiResponse.getSubMessage());
        gateWayApiResponse.setBizContent(bizApiResponse.getBizContent());
        return gateWayApiResponse;
    }
}
