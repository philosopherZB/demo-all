package com.philosopherzb.health.check.kafka;

import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;
import com.philosopherzb.health.check.exception.HealthCheckException;
import io.micrometer.core.instrument.util.StringUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.CooperativeStickyAssignor;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.boot.actuate.health.AbstractHealthIndicator;
import org.springframework.boot.actuate.health.Health;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.time.Duration;
import java.util.Collections;
import java.util.Properties;
import java.util.UUID;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.stream.StreamSupport;

/**
 * @author philosopherZB
 * @date 2022/3/22
 */
@Slf4j
public class KafkaHealthIndicator extends AbstractHealthIndicator {

    private static final String CONSUMER_GROUP_PREFIX = "health-check-";
    /**
     * 休眠时间默认不超过3s
     */
    private static final long DEFAULT_SLEEP_TIME = 3000L;

    private ExecutorService executor;
    private AtomicBoolean running;
    private Cache<String, String> cache;
    private String consumerGroupId;

    private KafkaConsumer<String, String> consumer;
    private KafkaProducer<String, String> producer;

    private final KafkaHealthProperties kafkaHealthProperties;

    public KafkaHealthIndicator(KafkaHealthProperties kafkaHealthProperties) {
        super("Kafka health check failed");
        this.kafkaHealthProperties = kafkaHealthProperties;
    }

    @Override
    protected void doHealthCheck(Health.Builder builder) {
        String expectedMessage;
        try {
            expectedMessage = sendKafkaMessage();
        } catch (HealthCheckException e) {
            builder.down(e).withDetail("topic", kafkaHealthProperties.getTopic())
                    .withDetail("serverAddress", kafkaHealthProperties.getServerAddress());
            return;
        }

        String key = createKeyFromMessageAndConsumerGroupId(expectedMessage);
        String receivedMessage = cache.getIfPresent(key);
        if (expectedMessage.equals(receivedMessage)) {
            builder.up();
        } else {
            builder.down().withDetail("topic", kafkaHealthProperties.getTopic())
                    .withDetail("serverAddress", kafkaHealthProperties.getServerAddress())
                    .withDetail("errorMsg", "received msg not equals expected msg");
        }
    }

    @PostConstruct
    public void init() {
        this.checkAndSet();
        this.configProducer();
        this.configConsumer();
        this.subscribe();

    }

    @PreDestroy
    public void shutdown() {
        running.set(false);
        executor.shutdownNow();
        producer.close();
        consumer.close();
    }

    private void checkAndSet() {
        this.executor = Executors.newSingleThreadExecutor();
        this.consumerGroupId = CONSUMER_GROUP_PREFIX + UUID.randomUUID();
        if (StringUtils.isBlank(kafkaHealthProperties.getServerAddress())) {
            throw new IllegalArgumentException("health.check.kafka.serverAddress value is empty");
        }
        this.running = new AtomicBoolean(true);
        this.cache = Caffeine.newBuilder()
                .expireAfterWrite(kafkaHealthProperties.getCacheMaxTime(), TimeUnit.MINUTES)
                .maximumSize(kafkaHealthProperties.getCacheMaximumSize())
                .build();
    }

    private void configProducer() {
        Properties producerProps = new Properties();
        producerProps.put("bootstrap.servers", kafkaHealthProperties.getServerAddress());
        producerProps.put("acks", "all");
        producerProps.put("retries", "0");
        producerProps.put("key.serializer", StringSerializer.class.getName());
        producerProps.put("value.serializer", StringSerializer.class.getName());
        this.producer = new KafkaProducer<>(producerProps);
    }

    private void configConsumer() {
        Properties consumerProps = new Properties();
        consumerProps.put("bootstrap.servers", kafkaHealthProperties.getServerAddress());
        consumerProps.put("group.id", this.consumerGroupId);
        consumerProps.put("enable.auto.commit", "true");
        consumerProps.put("key.deserializer", StringDeserializer.class.getName());
        consumerProps.put("value.deserializer", StringDeserializer.class.getName());
        // 设置分区分配模式为 CooperativeStickyAssignor
        consumerProps.put(ConsumerConfig.PARTITION_ASSIGNMENT_STRATEGY_CONFIG, CooperativeStickyAssignor.class.getName());
        this.consumer = new KafkaConsumer<>(consumerProps);
    }

    private void subscribe() {
        this.consumer.subscribe(Collections.singletonList(kafkaHealthProperties.getTopic()));
        executor.submit(() -> {
            while (running.get()) {
                ConsumerRecords<String, String> records = consumer.poll(Duration.ofMillis(kafkaHealthProperties.getPollTimeout()));
                StreamSupport.stream(records.spliterator(), false)
                        .filter(record -> record.key() != null && record.key().contains(consumerGroupId))
                        .forEach(record -> cache.put(record.key(), record.value()));
            }
        });
    }

    private String sendKafkaMessage() throws HealthCheckException {
        String msg = UUID.randomUUID().toString();
        String key = this.createKeyFromMessageAndConsumerGroupId(msg);
        log.debug("send health check message:{}, key:{}", msg, key);

        try {
            this.producer.send(new ProducerRecord<>(kafkaHealthProperties.getTopic(), key, msg))
                    .get(kafkaHealthProperties.getSendAndReceiveTimeout(), TimeUnit.MILLISECONDS);
            // 等待消息发送成功
            Thread.sleep(getSleepTime());
        } catch (InterruptedException | TimeoutException e) {
            log.debug("kafka health check time out, e: ", e);
            throw new HealthCheckException(e);
        } catch (ExecutionException e) {
            log.debug("kafka health check execution failed, e: ", e);
            throw new HealthCheckException(e);
        }
        return msg;

    }

    private String createKeyFromMessageAndConsumerGroupId(String message) {
        return message + "-" + consumerGroupId;
    }

    private long getSleepTime() {
        long sleepTime = Math.min(kafkaHealthProperties.getSendAndReceiveTimeout(), DEFAULT_SLEEP_TIME);
        return sleepTime + 1;
    }
}
