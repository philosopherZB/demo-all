package com.philosopherzb.rocketmq.springboot.consume;

import com.aliyun.openservices.ons.api.MessageListener;
import com.aliyun.openservices.ons.api.PropertyKeyConst;
import com.aliyun.openservices.ons.api.bean.ConsumerBean;
import com.aliyun.openservices.ons.api.bean.Subscription;
import com.philosopherzb.rocketmq.springboot.config.MqConfig;
import com.philosopherzb.rocketmq.springboot.constant.MqConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * author: philosopherZB
 * date: 2020/9/4
 */
@Component
public class TestConsumerClient {

    @Resource
    private MqConfig mqConfig;

    @Resource
    @Qualifier("testMessageListener")
    private MessageListener messageListener;

    @Bean(name = "testConsumerBean", initMethod = "start", destroyMethod = "shutdown")
    public ConsumerBean consumerBean() {
        ConsumerBean consumerBean = new ConsumerBean();
        //配置文件
        Properties properties = mqConfig.getMqProperties();
        properties.setProperty(PropertyKeyConst.GROUP_ID, mqConfig.getGroupId());
        properties.put(PropertyKeyConst.MaxReconsumeTimes, mqConfig.getRetryTimes());
        properties.put(PropertyKeyConst.ConsumeTimeout, mqConfig.getTimeout());
        //将消费者线程数固定为20个 20为默认值
        properties.setProperty(PropertyKeyConst.ConsumeThreadNums, mqConfig.getConsumeThreadNum());
        consumerBean.setProperties(properties);
        //订阅关系，多个tag使用||隔开
        Map<Subscription, MessageListener> subscriptionTable = new HashMap<>();
        Subscription subscription = new Subscription();
        subscription.setTopic(mqConfig.getTopic());
        // tag
        subscription.setExpression(MqConstant.TEST);
        subscriptionTable.put(subscription, messageListener);
        //订阅多个topic如上面设置

        consumerBean.setSubscriptionTable(subscriptionTable);
        return consumerBean;
    }

}
