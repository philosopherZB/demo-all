package com.philosopherzb.springkafka.consumer.listener;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.CooperativeStickyAssignor;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;

import java.time.Duration;
import java.util.Collections;
import java.util.Properties;

/**
 * @author philosopherZB
 * @date 2022/6/27
 */
public class TestConsumer {

    public static void main(String[] args) {
        new TestConsumer().subscribe();
    }

    private void subscribe() {
        Properties consumerProps = new Properties();
        consumerProps.put("bootstrap.servers", "127.0.0.1:9200");
        consumerProps.put("group.id", "groupId");
        consumerProps.put("enable.auto.commit", "true");
        consumerProps.put("key.deserializer", StringDeserializer.class.getName());
        consumerProps.put("value.deserializer", StringDeserializer.class.getName());
        // 设置分区分配模式为 CooperativeStickyAssignor
        consumerProps.put(ConsumerConfig.PARTITION_ASSIGNMENT_STRATEGY_CONFIG, CooperativeStickyAssignor.class.getName());
        KafkaConsumer<String, String> consumer = new KafkaConsumer<>(consumerProps);

        consumer.subscribe(Collections.singletonList("testTopic"));
        ConsumerRecords<String, String> records = consumer.poll(Duration.ofMillis(3000));
        records.forEach(record -> {
            System.out.println("TestConsumer.key: " + record.key());
            System.out.println("TestConsumer.value: " + record.value());
        });
    }

}
