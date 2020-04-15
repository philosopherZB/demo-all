package com.philosopherzb.shardingdb.domain;

import lombok.Data;

import java.util.Date;

/**
 * author: philosopherZB
 * date: 2020/3/4
 */
@Data
public class TbUser {
    private Long id;
    /** 用户id*/
    private Long userId;
    /** 分表键*/
    private Long shardingKey;
    /** 用户姓名*/
    private String userName;
    /** 创建时间*/
    private Date createTime;
    /** 更新时间*/
    private Date modifyTime;
}
