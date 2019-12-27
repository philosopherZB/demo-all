package com.philosopherzb.springaop.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * author: philosopherZB
 * date: 2019/12/26
 */
@Data
public class UserDto implements Serializable {
    private static final long serialVersionUID = 1620165925354861458L;

    private String userId;

    private String userName;

    private Integer age;

}
