package com.philosopherzb.nettydemo.request;

import lombok.Data;

import java.io.Serializable;

/**
 * author: philosopherZB
 * date: 2020/8/14
 */
@Data
public class NettyRequest implements Serializable {

    private static final long serialVersionUID = -3524590530043362078L;
    private String encryptData;
}
