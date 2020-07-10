package com.lqq.demo.spring.aware;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Classname Test
 * @Description TODO
 * @Date 2020/7/9 15:00
 * @Created by lanqq
 */
public class Test implements BeanFactoryAware {

    private BeanFactory beanFactory;

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.beanFactory = beanFactory;
    }

    public void testAware() {
        Hello hello = (Hello)beanFactory.getBean("hello");
        hello.say();
    }

    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("beanXMLTest.xml");
        Test test = (Test) ctx.getBean("test");
        test.testAware();

    }
}
