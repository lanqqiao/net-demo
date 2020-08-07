package com.lqq.demo.mqTrasation;

import com.alibaba.fastjson.JSON;
import com.xiaoleilu.hutool.lang.Snowflake;
import org.apache.rocketmq.client.exception.MQClientException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @ClassName OrderServiceImpl
 * @Description TODO
 * @Author jiebai
 * @Date 2020/8/7 11:54
 * @Version 1.0
 **/
@Component
@Service
public class OrderServiceImpl implements OrderService {

    @Resource
    private JdbcTemplate jdbcTemplate;

    @Autowired
    TransactionProducer producer;

    Snowflake snowflake = new Snowflake(1,1);
    Logger logger = LoggerFactory.getLogger(this.getClass());

    //执行本地事务时调用，将订单数据和事务日志写入本地数据库
    @Transactional
    @Override
    public void createOrder(OrderDTO orderDTO,String transactionId){

        //1.创建订单
        jdbcTemplate.update("insert into tb_order(orderId, descs) values(?, ?)", new Object[] {orderDTO.getOrderId(),
            orderDTO.getDescs()});

        //2.写入事务日志
        jdbcTemplate.update("insert into transaction_log(id, business, foreign_key) values(?, ?, ?)",
            new Object[] {transactionId, "order", orderDTO.getOrderId()});
        logger.info("订单创建完成。{}",orderDTO);
    }

    //前端调用，只用于向RocketMQ发送事务消息
    @Override
    public void createOrder(OrderDTO order) throws MQClientException {
        order.setOrderId(snowflake.nextId());
        order.setDescs(snowflake.nextId() + "==str==");
        producer.send(JSON.toJSONString(order),"order");
    }
}
