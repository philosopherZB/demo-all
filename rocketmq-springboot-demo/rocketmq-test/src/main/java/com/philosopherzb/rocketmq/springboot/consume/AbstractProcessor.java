package com.philosopherzb.rocketmq.springboot.consume;

import com.aliyun.openservices.ons.api.Action;
import com.aliyun.openservices.ons.api.ConsumeContext;
import com.aliyun.openservices.ons.api.Message;
import com.aliyun.openservices.ons.api.MessageListener;

/**
 * author: philosopherZB
 * date: 2020/11/26
 */
public abstract class AbstractProcessor implements MessageListener {

    @Override
    public Action consume(Message message, ConsumeContext context) {
        Action action = handleMessage(message);
        int threshold = getThreshold();
        if (message.getReconsumeTimes() + 3 > threshold && Action.ReconsumeLater.equals(action)) {
            consumeFailure(message);
            return Action.CommitMessage;
        }
        return action;
    }

    /**
     * 消息消费达到上限，需要进行入库等操作
     *
     * @param message 消息
     */
    protected abstract void consumeFailure(Message message);

    /**
     * 处理消息
     *
     * @param message 消息
     * @return 处理结果
     */
    protected abstract Action handleMessage(Message message);

    /**
     * 当消息消费次数达到上限时，需要将消息入库
     *
     * @return 重试次数
     */
    protected abstract int getThreshold();
}
