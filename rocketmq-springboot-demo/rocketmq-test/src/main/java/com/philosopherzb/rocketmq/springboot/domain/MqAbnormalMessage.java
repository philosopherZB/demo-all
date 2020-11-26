package com.philosopherzb.rocketmq.springboot.domain;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * author: philosopherZB
 * date: 2020/11/19
 */
@Data
public class MqAbnormalMessage implements Serializable {

    private static final long serialVersionUID = 1045819140664177202L;
    /**
     * id
     */
    private Long id;

    /**
     * 消息队列的topic
     */
    private String topic;

    /**
     * 消息的groupId
     */
    private String group;

    /**
     * 消息的tag
     */
    private String tag;

    /**
     * 消息的key
     */
    private String key;

    /**
     * 自定义消费事件类型
     */
    private String type;

    /**
     * 用户属性
     */
    private String userProperties;

    /**
     * 消息id
     */
    private String messageId;

    /**
     * 重试次数
     */
    private Integer retryTime;

    /**
     * 消息内容
     */
    private String body;

    /**
     * 错误信息
     */
    private String errorMsg;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date modifyTime;
}
