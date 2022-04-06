package com.philosopherzb.springkafka.consumer.assignor;

import org.apache.kafka.clients.consumer.internals.AbstractPartitionAssignor;
import org.apache.kafka.common.TopicPartition;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author philosopherZB
 * @date 2022/4/6
 */
public class FailoverAssignor extends AbstractPartitionAssignor {

    @Override
    public String name() {
        return "failover";
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

            Integer numPartitionsForTopic = partitionsPerTopic.get(topic);
            if (numPartitionsForTopic == null) {
                continue;
            }

            // 按字典排序
            Collections.sort(consumersForTopic);

            List<TopicPartition> partitions = AbstractPartitionAssignor.partitions(topic, numPartitionsForTopic);
            // 没有消费者则跳过
            if (consumersForTopic.isEmpty()) {
                continue;
            }
            // 取排序列表中的第一个消费者
            String consumerMemberId = consumersForTopic.stream().findFirst().get().memberId;
            assignment.get(consumerMemberId).addAll(partitions);
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
