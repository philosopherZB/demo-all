package com.philosopherzb.health.check.xxljob;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author philosopherZB
 * @date 2022/3/22
 */
@Data
@ConfigurationProperties(prefix = "health.check.xxljob")
public class XxlJobHealthProperties {
    /**
     * 是否启动xx-job健康监测
     * 可选值：true & false
     * 默认 false
     */
    private String enabled = "false";

    /**
     * xxl-job admin address list, such as "http://address" or "http://address01,http://address02"
     */
    private String adminAddresses;
    /**
     * xxl-job, access token
     */
    private String accessToken;
    /**
     * xxl-job executor appname
     */
    private String appname;
    /**
     * xxl-job executor registry-address: default use address to registry , otherwise use ip:port if address is null
     */
    private String address;
    /**
     * xxl-job executor server-info:ip
     */
    private String ip;
    /**
     * xxl-job executor server-info:port
     */
    private int port;
    /**
     * xxl-job executor log-path
     */
    private String logPath;
    /**
     * xxl-job executor log-retention-days
     */
    private int logRetentionDays;

    /**
     * 执行间隔，此时间与xxl-web界面配置的cron表达式一致，例如xxl-web配置了每30秒执行一次任务，此值则配置为30
     * 注意：此值大小不能超过 cacheMaxTime, 且不宜设置过大
     * 单位：秒
     * 默认 30s
     */
    private long executeInterval = 30;
    /**
     * 消费者缓存消息的过期时间
     * 单位：分钟
     * 默认 10min
     */
    private int cacheMaxTime = 10;
    /**
     * 消费者缓存的消息条数
     * 默认 1条
     */
    private int cacheMaximumSize = 1;
}
