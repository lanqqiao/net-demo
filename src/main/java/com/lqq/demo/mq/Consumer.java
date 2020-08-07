package com.lqq.demo.mq;

import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.common.consumer.ConsumeFromWhere;
import org.apache.rocketmq.common.message.MessageExt;
import org.apache.rocketmq.common.protocol.heartbeat.MessageModel;

import java.util.List;

/**
 * @ClassName Consumer
 * @Description TODO
 * @Author jiebai
 * @Date 2020/8/4 19:24
 * @Version 1.0
 **/
public class Consumer {

    public static void main(String[] args) throws MQClientException {
        /*
         * Instantiate with specified Consumer group name.
         */
        DefaultMQPushConsumer Consumer = new DefaultMQPushConsumer("TopicTestGroup");
        /*
         * Specify name server addresses.
         */
        Consumer.setNamesrvAddr("192.168.7.146:9876;192.168.7.78:9876");
        /*
         * Specify where to start in case the specified Consumer group is a brand new one.
         */
        Consumer.setConsumeFromWhere(ConsumeFromWhere.CONSUME_FROM_FIRST_OFFSET);
        Consumer.setMessageModel(MessageModel.BROADCASTING);
        /*
         * Subscribe one more more Topics to consume.
         */
        Consumer.subscribe("TopicTest", "*");
        /*
         *  Register callback to execute on arrival of Messages fetched from brokers.
         */
        Consumer.registerMessageListener(new MessageListenerConcurrently() {
            public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> msgs,
                ConsumeConcurrentlyContext context) {
                System.out.printf(Thread.currentThread().getName() + " Receive New Messages: " + msgs + "%n");
                return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
            }
        });
        /*
         *  Launch the Consumer instance.
         */
        Consumer.start();
    }
}
