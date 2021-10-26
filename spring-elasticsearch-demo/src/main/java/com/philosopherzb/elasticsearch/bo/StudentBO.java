package com.philosopherzb.elasticsearch.bo;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author philosopherZB
 * @date 2021/10/22
 */
@Data
public class StudentBO implements Serializable {
    private static final long serialVersionUID = -850870156502839452L;

    private Long id;

    private String name;

    private Integer age;

    private String description;

    /**
     * 13位时间戳: System.currentTimeMillis()
     */
    private Long createTime;
}
