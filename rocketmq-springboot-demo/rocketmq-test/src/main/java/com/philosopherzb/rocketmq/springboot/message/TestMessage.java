package com.philosopherzb.rocketmq.springboot.message;

import lombok.Data;

import java.io.Serializable;

/**
 * author: philosopherZB
 * date: 2020/11/26
 */
@Data
public class TestMessage implements Serializable {
    private static final long serialVersionUID = -4607762079182435159L;

    private String id;

    private String name;

}
