DROP TABLE IF EXISTS `tb_kafka_abnormal_message`;
CREATE TABLE `tb_kafka_abnormal_message` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `topic` varchar(32) NOT NULL COMMENT '消息主题',
  `msg_partition` int(4) DEFAULT NULL COMMENT '消息分区',
  `listener_id` varchar(32) DEFAULT NULL COMMENT '监听器id，用于表示监听器在容器中的唯一性',
  `group_id` varchar(32) DEFAULT NULL COMMENT '消息组id，用来标识消费者组的唯一性',
  `msg_key` varchar(32) DEFAULT NULL COMMENT '消息key',
  `content` text DEFAULT NULL COMMENT '消息内容，一般以json字符串存储',
  `msg_type` varchar(64) DEFAULT NULL COMMENT '自定义消息类型',
  `retry_count` int(2) DEFAULT NULL COMMENT '重试次数',
  `error_msg` varchar(512) DEFAULT NULL COMMENT '抛出的异常消息',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `modify_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='kafka异常消息记录表';