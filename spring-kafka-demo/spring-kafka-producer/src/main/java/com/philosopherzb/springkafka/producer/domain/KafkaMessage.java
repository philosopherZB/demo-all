package com.philosopherzb.springkafka.producer.domain;

import com.philosopherzb.springkafka.producer.constant.TopicEnum;
import lombok.Data;

/**
 * @author philosopherZB
 * @date 2021/4/21
 */
@Data
public class KafkaMessage {
    /**
     * 一般为uuid值,非必传
     */
    private String key;
    /**
     * 消息内容，格式：json字符串，必传
     */
    private String content;

    /**
     * 指定要发送的topic，必传
     */
    private TopicEnum topic;
}
