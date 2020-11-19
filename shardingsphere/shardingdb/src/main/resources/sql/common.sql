DROP TABLE IF EXISTS `t_test`;
CREATE TABLE `t_test` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `test_id` varchar(32) NOT NULL comment '测试id',
  `test_name` varchar(32) NOT NULL COMMENT '测试名称',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `modify_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`),
  index `idx_test_id` (`test_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='测试表';

CREATE TABLE `t_test` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `test_id` varchar(32) NOT NULL comment '测试id',
  `test_name` varchar(32) NOT NULL COMMENT '测试名称',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `modify_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `idx_test_id` (`test_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='测试表';

CREATE TABLE `t_test` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `test_id` varchar(32) NOT NULL comment '测试id',
  `test_name` varchar(32) NOT NULL COMMENT '测试名称',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `modify_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `idx_testId_testName` (`test_id`, `test_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='测试表';

alter table `t_test` add test_age varchar(32) DEFAULT NULL COMMENT '测试年龄' after `test_name`;
explain select * from t_test;


-- 批量建表存储过程
drop PROCEDURE if EXISTS batchProcess;
create procedure batchProcess(
in str_sql varchar(512),
in table_name_prefix varchar(64),
in logic_table_name varchar(64),
in n_start int,
in n_stop int,
in len int)

begin

DECLARE i int;
DECLARE shard_table varchar(128);
set i=n_start ;
while i<=n_stop do

set shard_table = CONCAT(table_name_prefix,LPAD(i,len,'0'));
set @sql = replace(replace(str_sql,'table_name_prefix',shard_table),'logic_table_name',logic_table_name);
prepare stmt from @sql;
EXECUTE stmt;
deallocate prepare stmt;

set i=i+1;
end while;
end;


-- 批处理任务，0，9表示分表的后缀为000到001
call batchProcess('create table if not exists table_name_prefix like logic_table_name','t_test_','t_test_logic',0,99,3);



-- 存储过程批量生成压测数据
CREATE FUNCTION rand_string(n INT) RETURNS VARCHAR(255)
BEGIN
DECLARE chars_str varchar(100) DEFAULT '7985013663753348798328920982364169120931740335042929603390232457';
DECLARE return_str varchar(255) DEFAULT '';
DECLARE i INT DEFAULT 0;
WHILE i < n DO
SET return_str = concat(return_str,substring(chars_str , FLOOR(1 + RAND()*62 ),1));
SET i = i +1;
END WHILE;
RETURN return_str;
END;

delimiter //
create procedure kmind()
begin
    declare i int;  # declare语句是在复合语句中声明变量的指令
    set i=1;

    while i<=5 do
      insert into t_test (`test_id`, `test_name`)
       values (rand_string(32), 'Test001');
      set i=i+1;
    end while;
end
//
delimiter ;

SHOW CREATE PROCEDURE `union-member`.kmind;
CALL kmind(); # call 调用存储过程
drop procedure kmind; # 删除mysql存储过程
drop function rand_string; # 删除mysql函数


-- 取当前日期前一天
select date_format(date_sub(curdate(),interval 1 day), '%Y-%m-%d 00:00:00');
select date_format(date_sub(curdate(),interval 1 day), '%Y-%m-%d 23:59:59');
select curtime();
-- 当月第一天
select DATE_ADD(curdate(),interval -day(curdate())+1 day);



-- 每天付费用户总数（包括续约）
select sum(tab_all.cnt), tab_all.dat from (
((SELECT count(*) as cnt, date_format(create_time, '%Y-%m-%d') as dat from t_test_000 where stat=1 group by dat)) union ALL
((SELECT count(*) as cnt, date_format(create_time, '%Y-%m-%d') as dat from t_test_001 where stat=1 group by dat))) as tab_all GROUP BY dat;

-- 按天累计当月的退订数
SELECT a.day, SUM(b.cnt) AS total
FROM (
    SELECT DATE_FORMAT(unsign_time, '%Y-%m-%d') AS day
    FROM t_test where agreement_state = '1' and date_format(create_time, '%Y-%m-%d') >= (select DATE_ADD(curdate(),interval -day(curdate())+1 day))
    GROUP BY day
     ) a
INNER JOIN (
    SELECT  DATE_FORMAT(unsign_time, '%Y-%m-%d') AS day, COUNT(*) AS cnt
    FROM t_test  where agreement_state = '1' and date_format(create_time, '%Y-%m-%d') >= (select DATE_ADD(curdate(),interval -day(curdate())+1 day))
    GROUP BY day
    ) b
    ON a.day >= b.day
GROUP BY a.day
ORDER BY a.day;

-- 每天开通并退订的用户数
select count(*), date_format(unsign_time, '%Y-%m-%d') day from `t_test` where agreement_state = '1' and date_format(unsign_time, '%Y-%m-%d') = date_format(create_time, '%Y-%m-%d') group by day;

-- 每天开通总数（包括当日退订数），即日净增用户数
select count(*), date_format(create_time, '%Y-%m-%d') day from t_test group by day;

-- 每月开通总数（包括当月退订数），即月净增用户数
select count(*), date_format(create_time, '%Y-%m') day from t_test group by day;

-- 每日油品券核销量
select sum(t.cnt), t.dat from (
(select count(*) as cnt, date_format(create_time, '%Y-%m-%d') as dat from t_test_000 where coupon_type=1 group by date_format(create_time, '%Y-%m-%d')) union all
(select count(*) as cnt, date_format(create_time, '%Y-%m-%d') as dat from t_test_001 where coupon_type=1 group by date_format(create_time, '%Y-%m-%d'))) as t group by dat;

-- 每日非油品券核销量
select sum(t.cnt), t.dat from (
(select count(*) as cnt, date_format(create_time, '%Y-%m-%d') as dat from t_test_000 where coupon_type=2 group by date_format(create_time, '%Y-%m-%d')) union all
(select count(*) as cnt, date_format(create_time, '%Y-%m-%d') as dat from t_test_001 where coupon_type=2 group by date_format(create_time, '%Y-%m-%d'))) as t group by dat;

-- 每周阿里权益领取量
select sum(t.cnt), t.camp_id, t.alipay_rights_name, t.week from (
select count(camp_id) as cnt, camp_id, alipay_rights_name, WEEK(modify_time, 5) as week from t_test_000 where status = '1' group by camp_id, week union all
select count(camp_id) as cnt, camp_id, alipay_rights_name, WEEK(modify_time, 5) as week from t_test_001 where status = '1' group by camp_id, week) as t group by t.camp_id, t.week ORDER BY t.week desc;

