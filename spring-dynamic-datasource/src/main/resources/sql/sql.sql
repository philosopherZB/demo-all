
-- 建立名称为db_user_write的数据库并设置字符编码，自己测试
-- CREATE DATABASE db_user CHARACTER SET utf8 COLLATE utf8_general_ci;
CREATE TABLE `tb_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `user_name` varchar(32) NOT NULL COMMENT '用户姓名',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `modify_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='用户信息表';



-- 建立名称为db_person_read的数据库并设置字符编码，自己测试
-- CREATE DATABASE db_person CHARACTER SET utf8 COLLATE utf8_general_ci;
CREATE TABLE `tb_person` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `person_name` varchar(32) NOT NULL COMMENT '人员姓名',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `modify_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='人员信息表';