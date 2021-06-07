package com.lqq.demo.spring.aop;

/**
 * @ClassName AopTestBean
 * @Description TODO
 * @Author jiebai
 * @Date 2021/6/7 10:27
 * @Version 1.0
 **/
public class AopTestBean {

    public int add(int a, int b) {
        return a + b;
    }

    public int test(int a, int b) {
        return add(a, b);
    }

    public String getName() {
        return this.getClass().getName();
    }
}
