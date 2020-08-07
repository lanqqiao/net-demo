package com.lqq.demo.mq;

import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
 import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
 import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
 import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
 import org.apache.rocketmq.common.message.MessageExt;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class ScheduledMessageConsumer {

    public static void main(String[] args) throws Exception {
        // Instantiate message consumer
        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer("ExampleConsumer");
        // Subscribe topics
        consumer.setNamesrvAddr("192.168.7.146:9876;192.168.7.78:9876");
        consumer.subscribe("TopicTest", "*");
        // Register message listener
        consumer.registerMessageListener(new MessageListenerConcurrently() {
            @Override
            public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> messages, ConsumeConcurrentlyContext context) {
                for (MessageExt message : messages) {
                    // Print approximate delay time period
                    System.out.println("ReceiveTime:" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
                    System.out.println("storeTime:" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(message.getStoreTimestamp())));

                    System.out.println("Receive message[msgId=" + message.getMsgId() + "] "
                            + (System.currentTimeMillis()));
                }
                return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
            }
        });
        // Launch consumer
        consumer.start();
    }
}