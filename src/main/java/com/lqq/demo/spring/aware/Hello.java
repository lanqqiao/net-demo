package com.lqq.demo.spring.aware;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Classname Hello
 * @Description TODO
 * @Date 2020/7/9 14:59
 * @Created by lanqq
 */
public class Hello {

    Test test;

    public void say() {
        System.out.println("hello");
    }
}
