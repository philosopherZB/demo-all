-- 在以下两个库中分别建立user0和user1表
-- 建立名称为db_user_0的数据库并设置字符编码，自己测试
-- CREATE DATABASE db_user_0 CHARACTER SET utf8 COLLATE utf8_general_ci;
-- 建立名称为db_user_1的数据库并设置字符编码，自己测试
-- CREATE DATABASE db_user_1 CHARACTER SET utf8 COLLATE utf8_general_ci;
DROP TABLE IF EXISTS `tb_user_0`;
CREATE TABLE `tb_user_0` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `user_id` bigint(20) NOT NULL COMMENT '用户id',
  `sharding_key` bigint(20) NOT NULL COMMENT '分表键',
  `user_name` varchar(32) NOT NULL COMMENT '用户姓名',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `modify_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='用户信息表';

DROP TABLE IF EXISTS `tb_user_1`;
CREATE TABLE `tb_user_1` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `user_id` bigint(20) NOT NULL COMMENT '用户id',
  `sharding_key` bigint(20) NOT NULL COMMENT '分表键',
  `user_name` varchar(32) NOT NULL COMMENT '用户姓名',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `modify_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='用户信息表';

