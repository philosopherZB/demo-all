package com.philosopherzb.rocketmq.springboot.dto;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Repository;

/**
 * author: philosopherZB
 * date: 2019/12/12
 */
@ConfigurationProperties(prefix = "demo.rocketmq")
@Data
@Repository
public class RocketPropertyDto {
    private String orderTopic;

    private String msgExtTopic;

    private String transTopic;

    private String topic;

    private String userTopic;

    private String extNameServer;
}
