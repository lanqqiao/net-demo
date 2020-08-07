package com.lqq.demo.mqTrasation;

/**
 * @ClassName TransactionLog
 * @Description TODO
 * @Author jiebai
 * @Date 2020/8/7 13:48
 * @Version 1.0
 **/
public class TransactionLogDTO {

    private String id;

    private String business;

    private String foreignKey;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBusiness() {
        return business;
    }

    public void setBusiness(String business) {
        this.business = business;
    }

    public String getForeignKey() {
        return foreignKey;
    }

    public void setForeignKey(String foreignKey) {
        this.foreignKey = foreignKey;
    }
}
