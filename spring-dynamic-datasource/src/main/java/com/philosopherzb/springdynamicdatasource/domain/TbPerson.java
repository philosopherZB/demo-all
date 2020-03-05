package com.philosopherzb.springdynamicdatasource.domain;

import lombok.Data;

import java.util.Date;

/**
 * author: philosopherZB
 * date: 2020/3/4
 */
@Data
public class TbPerson {
    /** 主键*/
    private Long id;
    /** 人员姓名*/
    private String personName;
    /** 创建时间*/
    private Date createTime;
    /** 更新时间*/
    private Date modifyTime;

    /** 该字段用于测试mybatis, as之后的映射值 **/
    private Integer countNum;
}
