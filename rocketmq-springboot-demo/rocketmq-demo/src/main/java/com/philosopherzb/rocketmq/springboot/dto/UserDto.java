package com.philosopherzb.rocketmq.springboot.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * author: philosopherZB
 * date: 2019/12/12
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserDto {

    private String userId;

    private String name;
}
