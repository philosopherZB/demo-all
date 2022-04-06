package com.philosopherzb.springkafka.consumer.assignor;

import org.apache.kafka.clients.consumer.internals.AbstractPartitionAssignor;
import org.apache.kafka.common.TopicPartition;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @author philosopherZB
 * @date 2022/4/6
 */
public class RandomAssignor extends AbstractPartitionAssignor {

    @Override
    public String name() {
        return "random";
    }

    @Override
    public Map<String, List<TopicPartition>> assign(Map<String, Integer> partitionsPerTopic, Map<String, Subscription> subscriptions) {
        Map<String, List<MemberInfo>> consumersPerTopic = consumersPerTopic(subscriptions);

        Map<String, List<TopicPartition>> assignment = new HashMap<>();
        for (String memberId : subscriptions.keySet()) {
            assignment.put(memberId, new ArrayList<>());
        }

        for (Map.Entry<String, List<MemberInfo>> topicEntry : consumersPerTopic.entrySet()) {
            String topic = topicEntry.getKey();
            List<MemberInfo> consumersForTopic = topicEntry.getValue();
            int consumerSize = consumersForTopic.size();

            Integer numPartitionsForTopic = partitionsPerTopic.get(topic);
            if (numPartitionsForTopic == null) {
                continue;
            }

            // 可不排序
            Collections.sort(consumersForTopic);

            List<TopicPartition> partitions = AbstractPartitionAssignor.partitions(topic, numPartitionsForTopic);
            partitions.forEach(partition -> {
                String randomConsumer = consumersForTopic.get(ThreadLocalRandom.current().nextInt(consumerSize)).memberId;
                assignment.get(randomConsumer).add(partition);
            });
        }
        return assignment;
    }

    private Map<String, List<MemberInfo>> consumersPerTopic(Map<String, Subscription> consumerMetadata) {
        Map<String, List<MemberInfo>> topicToConsumers = new HashMap<>();
        for (Map.Entry<String, Subscription> subscriptionEntry : consumerMetadata.entrySet()) {
            String consumerId = subscriptionEntry.getKey();
            MemberInfo memberInfo = new MemberInfo(consumerId, subscriptionEntry.getValue().groupInstanceId());
            for (String topic : subscriptionEntry.getValue().topics()) {
                put(topicToConsumers, topic, memberInfo);
            }
        }
        return topicToConsumers;
    }
}
