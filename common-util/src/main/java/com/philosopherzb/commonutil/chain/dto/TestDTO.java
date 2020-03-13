package com.philosopherzb.commonutil.chain.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * author: philosopherZB
 * date: 2020/3/13
 */
@Data
public class TestDTO implements Serializable {

    private static final long serialVersionUID = -3006995577669379824L;

    private String id;

    private String name;

    private String age;

    private String sex;
}
