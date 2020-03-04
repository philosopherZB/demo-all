package com.philosopherzb.springdynamicdatasource.domain;

import lombok.Data;

import java.util.Date;

/**
 * author: philosopherZB
 * date: 2020/3/4
 */
@Data
public class TbUser {
    /** 主键*/
    private Long id;
    /** 用户姓名*/
    private String userName;
    /** 创建时间*/
    private Date createTime;
    /** 更新时间*/
    private Date modifyTime;
}
