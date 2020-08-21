package com.philosopherzb.common.request;

import lombok.Data;

import java.io.Serializable;

/**
 * author: philosopherZB
 * date: 2020/8/21
 */
@Data
public class GateWayApiRequest implements Serializable {
    private static final long serialVersionUID = 5274422970517156031L;
    /**
     * 机构分配的id
     */
    private String accessId;

    /**
     * 请求时间戳，单位毫秒，System.currentTimeMillis()
     */
    private String timestamp;

    /**
     * 接口方法名
     */
    private String method;

    /**
     * 接口版本号
     */
    private String version;

    /**
     * 字符集标志，目前只支持utf-8
     */
    private String character;

    /**
     * 签名数据
     */
    private String signature;

    /**
     * 签名方式
     */
    private String signatureMethod;

    /**
     * 唯一随机数，用于防止网络重放攻击
     */
    private String signatureNonce;

    /**
     * 业务请求参数的Json字符串
     */
    private String bizContent;

}
