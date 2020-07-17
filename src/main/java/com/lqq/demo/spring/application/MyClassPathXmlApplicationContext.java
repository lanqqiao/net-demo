package com.lqq.demo.spring.application;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyClassPathXmlApplicationContext extends ClassPathXmlApplicationContext {

    public MyClassPathXmlApplicationContext(String... configLocations) {
        super(configLocations);
    }

    protected void initPropertySources() {
        getEnvironment().setRequiredProperties("VAR");
    }
}
