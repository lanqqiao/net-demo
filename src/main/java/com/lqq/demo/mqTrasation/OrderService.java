package com.lqq.demo.mqTrasation;

import org.apache.rocketmq.client.exception.MQClientException;

/**
 * @ClassName OrderService
 * @Description TODO
 * @Author jiebai
 * @Date 2020/8/7 11:54
 * @Version 1.0
 **/
public interface OrderService {

    void createOrder(OrderDTO orderDTO,String transactionId);

    void createOrder(OrderDTO order) throws MQClientException;
}
