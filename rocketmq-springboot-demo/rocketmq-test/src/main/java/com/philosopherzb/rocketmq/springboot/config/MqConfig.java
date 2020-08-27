package com.philosopherzb.rocketmq.springboot.config;

import com.aliyun.openservices.ons.api.PropertyKeyConst;
import lombok.Getter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.Properties;

/**
 * author: philosopherZB
 * date: 2020/8/25
 */
@Getter
@Configuration
@ConfigurationProperties(prefix = "rocketmq.aliyun")
public class MqConfig {

    /**
     * 接入用的accessKey
     */
    private String accessKey;
    /**
     * 接入用的secretKey
     */
    private String secretKey;
    /**
     * nameServer地址
     */
    private String nameServer;
    /**
     * topic
     */
    private String topic;
    /**
     * groupId
     */
    private String groupId;
    /**
     * tag
     */
    private String tag;
    /**
     * 消费者端线程数
     */
    private String consumeThreadNum;
    /**
     * 消费者端重试次数
     */
    private String retryTimes;
    /**
     * 消费者端超时时间
     */
    private String timeout;

    /**
     * 基本配置
     *
     * @return mq属性配置
     */
    public Properties getMqProperties() {
        Properties properties = new Properties();
        properties.setProperty(PropertyKeyConst.AccessKey, this.accessKey);
        properties.setProperty(PropertyKeyConst.SecretKey, this.secretKey);
        properties.setProperty(PropertyKeyConst.NAMESRV_ADDR, this.nameServer);
        properties.setProperty(PropertyKeyConst.GROUP_ID, this.groupId);
        return properties;
    }
}
