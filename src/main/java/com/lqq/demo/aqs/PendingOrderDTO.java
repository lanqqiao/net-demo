package com.lqq.demo.aqs;


import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * PendingOrderDTO
 *
 * @author huchuanyang
 * @date 2021/4/8 10:38
 */
public class PendingOrderDTO implements Serializable {
    /**
     * 订单编号
     */
    private String orderNo;

    /**
     * 下单时间
     */
    private Date gmtCreate;

    /**
     * 支付时间
     */
    private Date paymenTime;

    /**
     * 运费
     */
    private BigDecimal expressFee;

    /**
     * 分仓编码
     */
    private String subWarehouseCode;

    /**
     * 订单状态:0-交易关闭, 1-待付款,2-待发货,3-待收货(部分待收货部分申请退款,部分待收货部分已退款),4-交易完成,5-已退款
     */
    private String status;

    /**
     * 收货人
     */
    private String receiverName;

    /**
     * 联系电话
     */
    private String phone;

    /**
     * 省
     */
    private String provinceName;

    /**
     * 市
     */
    private String cityName;

    /**
     * 区
     */
    private String districtName;

    /**
     * 详细地址
     */
    private String streetAddress;


    /**
     * 订单金额
     */
    private BigDecimal orderAmount;

    /**
     * 实付金额
     */
    private BigDecimal rcvAmount;

    /**
     * 是否自提( true：是自提，false：非自提)
     */
    private Boolean ifExtract;

    public BigDecimal getOrderAmount() {
        if (orderAmount != null) {
            return orderAmount.setScale(2, BigDecimal.ROUND_HALF_UP);
        }
        return orderAmount;
    }

    public BigDecimal getRcvAmount() {
        if (rcvAmount != null) {
            return rcvAmount.setScale(2, BigDecimal.ROUND_HALF_UP);
        }
        return rcvAmount;
    }

    public String getStatus() {
        if (status != null){
            if (status.equals("0")){
                return "交易关闭";
            }
            if (status.equals("1")){
                return "待付款";
            }
            if (status.equals("2")){
                return "待付款";
            }
            if (status.equals("3")){
                return "待收货";
            }
            if (status.equals("4")){
                return "交易完成";
            }
        }
        return status;
    }
}
