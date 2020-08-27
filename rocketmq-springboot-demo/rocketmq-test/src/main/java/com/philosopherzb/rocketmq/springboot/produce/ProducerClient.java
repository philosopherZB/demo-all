package com.philosopherzb.rocketmq.springboot.produce;

import com.aliyun.openservices.ons.api.bean.ProducerBean;
import com.philosopherzb.rocketmq.springboot.config.MqConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;
import java.util.Properties;

/**
 * author: philosopherZB
 * date: 2020/8/26
 */
@Configuration
public class ProducerClient {

    @Resource
    private MqConfig mqConfig;

    @Bean(initMethod = "start", destroyMethod = "shutdown")
    public ProducerBean getProducerBean(){
        ProducerBean producerBean = new ProducerBean();
        Properties properties = mqConfig.getMqProperties();
        producerBean.setProperties(properties);
        return producerBean;
    }

}
