package com.lqq.demo.mq;

import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.apache.commons.lang3.time.FastDateFormat;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
 import org.apache.rocketmq.common.message.Message;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ScheduledMessageProducer {

    public static void main(String[] args) throws Exception {
        // Instantiate a producer to send scheduled messages
        DefaultMQProducer producer = new DefaultMQProducer("ExampleProducerGroup");
        // Launch producer
        producer.setNamesrvAddr("192.168.7.146:9876;192.168.7.78:9876");
        producer.start();
        int totalMessagesToSend = 1;
        for (int i = 0; i < totalMessagesToSend; i++) {
            Message message = new Message("TopicTest", ("Hello scheduled message " + 2).getBytes());
            // This message will be delivered to consumer 10 seconds later.
            message.setDelayTimeLevel(6);
            // Send the message
            producer.send(message);
            System.out.println("sendTime:" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        }

        // Shutdown producer after use.
        producer.shutdown();
    }

}