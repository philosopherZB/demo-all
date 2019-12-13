package com.philosopherzb.rocketmq.springboot.produce.listener;

import org.apache.rocketmq.spring.annotation.RocketMQTransactionListener;
import org.apache.rocketmq.spring.core.RocketMQLocalTransactionListener;
import org.apache.rocketmq.spring.core.RocketMQLocalTransactionState;
import org.apache.rocketmq.spring.support.RocketMQHeaders;
import org.springframework.messaging.Message;

import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * author: philosopherZB
 * date: 2019/12/12
 */
@RocketMQTransactionListener(txProducerGroup = "${demo.rocketmq.transTopic}")
public class TransactionListenerImpl implements RocketMQLocalTransactionListener {

    private AtomicInteger transactionIndex = new AtomicInteger(0);

    private ConcurrentHashMap<String,Integer> localTrans = new ConcurrentHashMap<>();

    @Override
    public RocketMQLocalTransactionState executeLocalTransaction(Message msg, Object arg) {
        String transId = (String)msg.getHeaders().get(RocketMQHeaders.TRANSACTION_ID);
        System.out.printf("TransactionListenerImpl.executeLocalTransaction is executed, msgTransactionId=%s %n", transId);

        int count = transactionIndex.getAndIncrement();
        int status = count % 3;
        localTrans.put(Objects.requireNonNull(transId),count);

        if (status == 0) {
            System.out.printf("    # COMMIT # Simulating msg %s related local transaction exec succeeded! ### %n", msg.getPayload());
            return RocketMQLocalTransactionState.COMMIT;
        }

        if (status == 1) {
            System.out.printf("    # ROLLBACK # Simulating %s related local transaction exec failed! %n", msg.getPayload());
            return RocketMQLocalTransactionState.ROLLBACK;
        }

        System.out.println("    # UNKNOWN # Simulating %s related local transaction exec UNKNOWN! ");
        return RocketMQLocalTransactionState.UNKNOWN;
    }

    @Override
    public RocketMQLocalTransactionState checkLocalTransaction(Message msg) {
        String transId = (String)msg.getHeaders().get(RocketMQHeaders.TRANSACTION_ID);
        RocketMQLocalTransactionState retStatus = RocketMQLocalTransactionState.COMMIT;
        Integer status = localTrans.get(Objects.requireNonNull(transId));
        if(status != null){
            switch (status){
                case 0:
                    retStatus = RocketMQLocalTransactionState.UNKNOWN;
                    break;
                case 2:
                    retStatus = RocketMQLocalTransactionState.ROLLBACK;
                    break;
            }
        }
        System.out.printf("------ !!!TransactionListenerImpl.checkLocalTransaction is executed once," +
                        " msgTransactionId=%s, TransactionState=%s status=%s %n",
                transId, retStatus, status);
        return retStatus;
    }
}
