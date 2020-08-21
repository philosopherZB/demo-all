package com.philosopherzb.gateway.handler;


import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.dubbo.config.ReferenceConfig;
import org.apache.dubbo.config.RegistryConfig;
import org.apache.dubbo.rpc.service.GenericService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.concurrent.ConcurrentHashMap;

/**
 * author: philosopherZB
 * date: 2020/8/21
 */
@Slf4j
@Component
public class DubboServiceHandler {
    /**
     * 连接注册中心配置
     */
    private RegistryConfig dubboRegConfig = new RegistryConfig();

    // 远程服务缓存，放在内存中
    private ConcurrentHashMap<String, GenericService> remoteServiceCache = new ConcurrentHashMap<>();

    // 重试次数
    private static final Integer RETRIES = 0;

    // 是否通用
    private static final String GENERIC = "true";

    @Value("${zookeeper.host}")
    private String zkAddress;

    @Value("${zookeeper.timeout}")
    private Integer timeOut;

    @Value("${zookeeper.protocol}")
    private String protocol;

    @PostConstruct
    public void start() {
        this.dubboRegConfig.setProtocol(protocol);
        this.dubboRegConfig.setAddress(zkAddress);
        this.dubboRegConfig.setTimeout(timeOut);
    }

    /**
     * 获取服务
     *
     * @param serviceName    服务名
     * @param serviceVersion 服务版本
     * @param dubboGroup     dubbo组
     * @return 服务bean
     */
    public GenericService getService(String serviceName, String serviceVersion, String dubboGroup) {
        String cacheKey = serviceName + "_" + serviceVersion + "_0";
        GenericService service = this.remoteServiceCache.get(cacheKey);
        // 缓存中没有该服务
        if (service == null) {
            ReferenceConfig<GenericService> reference = null;
            try {
                // 则创建一个
                reference = new ReferenceConfig<>();
                reference.setInterface(serviceName);
                reference.setVersion(serviceVersion);
                reference.setGeneric(GENERIC);
                reference.setRegistry(this.dubboRegConfig);
                if (StringUtils.isNotBlank(dubboGroup)) {
                    RegistryConfig group = this.dubboRegConfig;
                    group.setGroup(dubboGroup);
                    reference.setRegistry(group);
                }
                reference.setTimeout(timeOut);
                reference.setRetries(RETRIES);

                service = reference.get();
                // 并加入缓存
                this.remoteServiceCache.putIfAbsent(cacheKey, service);
            } catch (Exception e) {
                log.error("DubboServiceHandler.getService, occur exception, e:{}", e);
                if (reference != null) {
                    reference.destroy();
                }
            }
        }
        return service;
    }

}
