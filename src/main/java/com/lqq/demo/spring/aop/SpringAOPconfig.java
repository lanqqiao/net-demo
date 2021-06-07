package com.lqq.demo.spring.aop;

import org.aspectj.lang.annotation.AdviceName;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName SpringAOPconfig
 * @Description TODO
 * @Author jiebai
 * @Date 2021/6/7 10:26
 * @Version 1.0
 **/
public class SpringAOPconfig {

    @Bean
    public AopTestBean getAopTestBean() {
        return new AopTestBean();
    }

    @AdviceName("advice")
    public AspectJTest getAspectJTest() {
        return new AspectJTest();
    }
}
