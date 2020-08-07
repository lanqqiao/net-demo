package com.lqq.demo.mqTrasation;

/**
 * @ClassName OrderDTO
 * @Description TODO
 * @Author jiebai
 * @Date 2020/8/7 11:55
 * @Version 1.0
 **/
public class OrderDTO {

    private Long orderId;

    private String descs;

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public String getDescs() {
        return descs;
    }

    public void setDescs(String descs) {
        this.descs = descs;
    }
}
