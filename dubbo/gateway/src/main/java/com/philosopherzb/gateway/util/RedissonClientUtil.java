package com.philosopherzb.gateway.util;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.redisson.config.SingleServerConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StringUtils;

/**
 * author: philosopherZB
 * date: 2019/10/31
 * redisson客户端工具类
 */
@Configuration
public class RedissonClientUtil {

    /** redisson配置地址前缀 **/
    private static final String REDIS_PREFIX = "redis://";

    /**RLock对象中的锁名称**/
    public static final String DEFAULT_LOCK_NAME = "lockName";

    //redis密码
    @Value("${redisson.password}")
    private String redisPassword;

    //redisson单机配置的地址，格式：127.0.0.1:6379
    @Value("${redisson.single.address}")
    private String singleAddress;


    /**
     * 单机模式redisson客户端
     * @return 返回RedissonClient
     */
    @Bean(destroyMethod="shutdown")
    public RedissonClient getInstance() {
        Config config = new Config();
        String node = singleAddress;
        node = node.startsWith(REDIS_PREFIX) ? node : REDIS_PREFIX + node;
        SingleServerConfig serverConfig = config.useSingleServer()
                .setAddress(node);
        if (!StringUtils.isEmpty(redisPassword)) {
            serverConfig.setPassword(redisPassword);
        }
        return Redisson.create(config);
    }
}
