package com.philosopherzb.health.check.rocketmq;

import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;
import com.philosopherzb.health.check.exception.HealthCheckException;
import io.micrometer.core.instrument.util.StringUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.exception.RemotingException;
import org.springframework.boot.actuate.health.AbstractHealthIndicator;
import org.springframework.boot.actuate.health.Health;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.nio.charset.StandardCharsets;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * @author philosopherZB
 * @date 2022/3/22
 */
@Slf4j
public class RocketMQHealthIndicator extends AbstractHealthIndicator {

    private static final String GROUP_NAME_PREFIX = "health-check-";
    private static final String DEFAULT_TOPIC_NAME = "rocketmq-default-health-check-topic";
    /**
     * 休眠时间默认不超过3s
     */
    private static final long DEFAULT_SLEEP_TIME = 3000L;

    private Cache<String, String> cache;
    private String groupName;

    private DefaultMQPushConsumer consumer;
    private DefaultMQProducer producer;

    private final RocketMQHealthProperties rocketMQHealthProperties;

    public RocketMQHealthIndicator(RocketMQHealthProperties rocketMQHealthProperties) {
        super("Rocketmq health check failed");
        this.rocketMQHealthProperties = rocketMQHealthProperties;
    }

    @Override
    protected void doHealthCheck(Health.Builder builder) {
        String expectedMessage;
        try {
            expectedMessage = sendRockerMQMessage();
        } catch (HealthCheckException e) {
            builder.down(e).withDetail("topic", DEFAULT_TOPIC_NAME)
                    .withDetail("tag", rocketMQHealthProperties.getTag())
                    .withDetail("serverAddress", rocketMQHealthProperties.getServerAddress());
            return;
        }

        String key = createKeyFromMessageAndGroupName(expectedMessage);
        String receivedMessage = cache.getIfPresent(key);
        if (expectedMessage.equals(receivedMessage)) {
            builder.up();
        } else {
            builder.down().withDetail("topic", DEFAULT_TOPIC_NAME)
                    .withDetail("tag", rocketMQHealthProperties.getTag())
                    .withDetail("serverAddress", rocketMQHealthProperties.getServerAddress())
                    .withDetail("errorMsg", "received msg not equals expected msg");
        }
    }

    @PostConstruct
    public void init() {
        this.checkAndSet();
        this.configProducer();
        this.configConsumerAndSubscribe();
    }

    @PreDestroy
    public void shutdown() {
        producer.shutdown();
        consumer.shutdown();
    }

    private void checkAndSet() {
        this.groupName = GROUP_NAME_PREFIX + UUID.randomUUID();
        if (StringUtils.isBlank(rocketMQHealthProperties.getServerAddress())) {
            throw new IllegalArgumentException("health.check.rocketmq.serverAddress value is empty");
        }
        this.cache = Caffeine.newBuilder()
                .expireAfterWrite(rocketMQHealthProperties.getCacheMaxTime(), TimeUnit.MINUTES)
                .maximumSize(rocketMQHealthProperties.getCacheMaximumSize())
                .build();
    }

    private void configProducer() {
        this.producer = new DefaultMQProducer(this.groupName);
        producer.setNamesrvAddr(rocketMQHealthProperties.getServerAddress());
        try {
            producer.start();
            log.debug("rocketmq producer is start, serverAddress:{}, groupName:{}", rocketMQHealthProperties.getServerAddress(), this.groupName);
        } catch (MQClientException e) {
            log.debug("init rocketmq producer failure, e: ", e);
            throw new HealthCheckException(e);
        }
    }

    private void configConsumerAndSubscribe() {
        this.consumer = new DefaultMQPushConsumer(this.groupName);
        consumer.setNamesrvAddr(rocketMQHealthProperties.getServerAddress());
        try {
            // 订阅一个或多个topic，以tag过滤不同类型的消息
            consumer.subscribe(DEFAULT_TOPIC_NAME, rocketMQHealthProperties.getTag());
            consumer.registerMessageListener((MessageListenerConcurrently) (msgs, context) -> {
                log.debug("rocketmq consumer receive new message: {}", msgs);
                msgs.forEach(msg -> cache.put(msg.getKeys(), new String(msg.getBody(), StandardCharsets.UTF_8)));
                // 标记该消息已成功消费
                return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
            });
            consumer.start();
            log.debug("rocketmq consumer is start, serverAddress:{}, groupName:{}", rocketMQHealthProperties.getServerAddress(), this.groupName);
        } catch (MQClientException e) {
            log.debug("init rocketmq consumer failure, e: ", e);
            throw new HealthCheckException(e);
        }
    }

    private String sendRockerMQMessage() throws HealthCheckException {
        String msg = UUID.randomUUID().toString();
        String key = this.createKeyFromMessageAndGroupName(msg);
        log.debug("send health check message:{}, key:{}", msg, key);

        Message message = new Message(DEFAULT_TOPIC_NAME, rocketMQHealthProperties.getTag(), msg.getBytes(StandardCharsets.UTF_8));
        message.setKeys(key);

        try {
            SendResult sendResult = producer.send(message, rocketMQHealthProperties.getSendTimeout());
            log.debug("rocketmq sendResultL:{}, key:{}", sendResult.toString(), key);
            // 等待消息发送成功
            Thread.sleep(getSleepTime());
        } catch (InterruptedException | RemotingException e) {
            log.debug("rocketmq health check time out, e: ", e);
            throw new HealthCheckException(e);
        } catch (MQClientException | MQBrokerException e) {
            log.debug("rocketmq health check client|broker failure, e: ", e);
            throw new HealthCheckException(e);
        }
        return msg;

    }

    private String createKeyFromMessageAndGroupName(String message) {
        return message + "-" + groupName;
    }

    private long getSleepTime() {
        long sleepTime = Math.min(rocketMQHealthProperties.getSendTimeout(), DEFAULT_SLEEP_TIME);
        return sleepTime + 1;
    }
}
