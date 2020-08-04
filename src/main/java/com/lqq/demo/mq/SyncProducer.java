package com.lqq.demo.mq;

import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.common.RemotingHelper;

public class SyncProducer {
    public static void main(String[] args) throws Exception {
        //Instantiate with a Producer group name.
        DefaultMQProducer Producer = new
            DefaultMQProducer("TopicTestGroup");
        Producer.setNamesrvAddr("192.168.7.146:9876");
        //Launch the instance.
        Producer.start();
        for (int i = 0; i < 10; i++) {
            //Create a Message instance, specifying Topic, tag and Message body.
            Message msg = new Message("TopicTest" /* Topic */,
                "TagA" /* Tag */,
                ("Hello RocketMQ " +
                    i).getBytes(RemotingHelper.DEFAULT_CHARSET) /* Message body */
            );
            //Call send Message to deliver Message to one of brokers.
            SendResult sendResult = Producer.send(msg);
            System.out.printf("%s%n", sendResult);
        }
        //Shut down once the Producer instance is not longer in use.
        Producer.shutdown();
    }
}