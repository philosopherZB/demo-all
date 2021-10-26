package com.philosopherzb.elasticsearch.config;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpHost;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestClientBuilder;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.Objects;

/**
 * @author philosopherZB
 * @date 2021/10/22
 */
@Slf4j
@Configuration
public class ElasticsearchRestClient {
    private static final Integer LENGTH = 2;
    private static final String HTTP_SCHEME = "http";

    @Resource
    private ElasticsearchProperties properties;

    @Bean(name = "restHighLevelClient")
    @ConditionalOnMissingBean
    public RestHighLevelClient restHighLevelClient(RestClientBuilder restClientBuilder) {
        return getRestHighLevelClient(restClientBuilder);
    }

    @Bean
    public RestClientBuilder restClientBuilder() {
        HttpHost[] hosts = Arrays.stream(properties.getClusterNodes())
                .map(this::getHttpHost)
                .filter(Objects::nonNull)
                .toArray(HttpHost[]::new);
        return RestClient.builder(hosts);
    }

    /**
     * 获取 httpHost
     *
     * @param node yaml配置节点信息
     * @return httpHost
     */
    private HttpHost getHttpHost(String node) {
        if (StringUtils.isNotEmpty(node)) {
            String[] address = StringUtils.split(node, ":");
            if (address.length == LENGTH) {
                return new HttpHost(address[0], Integer.parseInt(address[1]), HTTP_SCHEME);
            }
        }
        log.warn("ElasticsearchRestClient.getHttpHost, clusterNodes property config error");
        return null;
    }

    /**
     * 获取 RestHighLevelClient
     *
     * @param builder RestClientBuilder
     * @return RestHighLevelClient
     */
    private RestHighLevelClient getRestHighLevelClient(RestClientBuilder builder) {
        // setRequestConfigCallback or setHttpClientConfigCallback config
        // basic credential auth
        if (StringUtils.isNotEmpty(properties.getUsername()) && StringUtils.isNotEmpty(properties.getPassword())) {
            final CredentialsProvider credentialsProvider = new BasicCredentialsProvider();
            credentialsProvider.setCredentials(AuthScope.ANY, new UsernamePasswordCredentials(properties.getUsername(), properties.getPassword()));
            builder.setHttpClientConfigCallback(httpClientBuilder -> httpClientBuilder
                    .setDefaultCredentialsProvider(credentialsProvider));
        }
        return new RestHighLevelClient(builder);
    }

}

