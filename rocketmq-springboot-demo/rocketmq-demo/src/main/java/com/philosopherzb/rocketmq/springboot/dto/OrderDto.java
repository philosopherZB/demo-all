package com.philosopherzb.rocketmq.springboot.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.math.BigDecimal;

/**
 * author: philosopherZB
 * date: 2019/12/12
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class OrderDto {

    private String orderID;

    private BigDecimal price;
}
