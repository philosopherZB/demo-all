package com.philosopherzb.commonutil.redis.redisson.util;

import org.apache.commons.lang3.StringUtils;
import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.ClusterServersConfig;
import org.redisson.config.Config;
import org.redisson.config.SingleServerConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * author: philosopherZB
 * date: 2019/10/31
 * redisson客户端工具类
 */
@Configuration
public class RedissonUtil {

    private static final String REDIS_PREFIX = "redis://";


    /**RLock对象中的锁名称. 默认**/
    public static final String DEFAULT_LOCK_NAME = "lockName";

    //redis密码
    @Value("${redisson.password}")
    private String redisPassword;

    //redisson单机配置的地址，格式：127.0.0.1:6379
    @Value("${redisson.single.address}")
    private String singleAddress;

    //redisson集群配置的地址，格式：127.0.0.1:6379;127.0.0.1:9089;
    @Value("${redisson.cluster.nodes}")
    private String clusterNodes;


    /**
     * 单机模式redisson客户端
     * @return 返回RedissonClient
     */
    @Bean(destroyMethod="shutdown")
    public RedissonClient redissonSingle() {
        Config config = new Config();
        String node = singleAddress;
        node = node.startsWith(REDIS_PREFIX) ? node : REDIS_PREFIX + node;
        SingleServerConfig serverConfig = config.useSingleServer()
                .setAddress(node);
        if (!org.springframework.util.StringUtils.isEmpty(redisPassword)) {
            serverConfig.setPassword(redisPassword);
        }
        return Redisson.create(config);
    }

    /**
     * 集群模式redisson客户端
     * @return 返回RedissonClient
     * 暂时不开启，因为本机没有集群
     */
//    @Bean(destroyMethod = "shutdown")
    public RedissonClient redissonCluster(){
        Config config = new Config();
        //集群设置必然会有多个node地址，此处可不必对分隔符进行判断是否含有
        String[] nodes = clusterNodes.split(";");
        List<String> newNodes = new ArrayList<>(nodes.length);
        Arrays.stream(nodes).forEach((index) -> newNodes.add(
                index.startsWith(REDIS_PREFIX) ? index : REDIS_PREFIX + index));

        ClusterServersConfig serverConfig = config.useClusterServers()
                .addNodeAddress(newNodes.toArray(new String[0]));
        if (StringUtils.isNotBlank(redisPassword)) {
            serverConfig.setPassword(redisPassword);
        }
        return Redisson.create(config);
    }
}
