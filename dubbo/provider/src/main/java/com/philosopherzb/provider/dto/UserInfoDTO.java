package com.philosopherzb.provider.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * author: philosopherZB
 * date: 2020/8/24
 */
@Data
public class UserInfoDTO implements Serializable {
    private static final long serialVersionUID = -2342352569092862791L;

    private String name;

    private String age;

    private String id;
}
