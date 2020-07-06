package com.lqq.demo.spring.customtag;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CustomTagTest {

    public static void main(String[] args) {
        ApplicationContext bf = new ClassPathXmlApplicationContext("customTagTest.xml");
        User user = (User) bf.getBean("testBean");
        System.out.println(user.getUserName() + "," + user.getEmail());
    }
}
