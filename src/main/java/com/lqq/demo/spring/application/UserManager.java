package com.lqq.demo.spring.application;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;

public class UserManager {

    private Date dataValue;

    public void setDataValue(Date dataValue) {
        this.dataValue = dataValue;
    }

    public Date getDataValue() {
        return dataValue;
    }

    @Override
    public String toString() {
        return "UserManager{" +
                "dataValue=" + dataValue +
                '}';
    }

    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
        Object userManager = ctx.getBean("userManager");
        System.out.println(userManager);
    }
}
