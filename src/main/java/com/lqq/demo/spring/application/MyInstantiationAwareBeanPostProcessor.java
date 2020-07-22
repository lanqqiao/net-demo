package com.lqq.demo.spring.application;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;

/**
 * @ClassName MyInstantiationAwareBeanPostProcessor
 * @Description TODO
 * @Author jiebai
 * @Date 2020/7/21 10:48
 * @Version 1.0
 **/
public class MyInstantiationAwareBeanPostProcessor implements BeanPostProcessor {

    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {

        System.out.println("===========");
        return null;
    }
}
