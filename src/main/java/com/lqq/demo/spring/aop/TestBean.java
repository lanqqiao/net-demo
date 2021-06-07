package com.lqq.demo.spring.aop;

import javafx.application.Application;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

/**
 * @ClassName TestBean
 * @Description TODO
 * @Author jiebai
 * @Date 2020/7/22 12:28
 * @Version 1.0
 **/
@Component
public class TestBean {

    private String testStr = "testStr";

    public String getTestStr() {
        return testStr;
    }

    public void setTestStr(String testStr) {
        this.testStr = testStr;
    }

    public void test() {
        System.out.println("test");
    }

    public static void main(String[] args) {
        ApplicationContext bf = new ClassPathXmlApplicationContext("beans.xml");
        TestBean bean = (TestBean) bf.getBean("test");
        bean.test();
    }
}
