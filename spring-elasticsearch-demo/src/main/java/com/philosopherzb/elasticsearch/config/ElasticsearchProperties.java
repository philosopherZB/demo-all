package com.philosopherzb.elasticsearch.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author philosopherZB
 * @date 2021/10/22
 */
@Data
@Configuration
@ConfigurationProperties(prefix = "elasticsearch.config")
public class ElasticsearchProperties {

    private String clusterName;

    /**
     * 集群节点列表，yaml格式：127.0.0.1:9000,127.0.0.1:9001
     */
    private String[] clusterNodes;

    private String username;

    private String password;

    /**
     * 创建索引时的副本数
     */
    private Integer indexReplicas;

    /**
     * 创建索引时的分片数
     */
    private Integer indexShards;
}
