package com.philosopherzb.springkafka.domain;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author philosopherZB
 * @date 2021/4/20
 */
@Data
@TableName(value = "tb_kafka_abnormal_message")
public class KafkaAbnormalMessage implements Serializable {
    private static final long serialVersionUID = 8915995823251043878L;
    /**
     * 自增主键
     */
    @TableId(value = "id")
    private long id;

    /**
     * 消息主题
     */
    private String topic;

    /**
     * 消息分区
     */
    private Integer msgPartition;

    /**
     * 监听器id，用于表示监听器在容器中的唯一性
     */
    private String listenerId;

    /**
     * 消息组id，用来标识消费者组的唯一性
     */
    private String groupId;

    /**
     * 消息key
     */
    private String msgKey;

    /**
     * 消息内容，一般以json字符串存储
     */
    private String content;

    /**
     * 自定义消息类型
     */
    private String msgType;

    /**
     * 重试次数
     */
    private Integer retryCount;

    /**
     * 抛出的异常消息
     */
    private String errorMsg;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 修改时间
     */
    private Date modifyTime;
}