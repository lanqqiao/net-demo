package com.lqq.demo.spring;

import com.lqq.demo.spring.application.MyClassPathXmlApplicationContext;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

@Component
public class TestBean {

    UserService userService;

    public String showMsg;

    public String name;

//    public TestBean(String showMsg) {
//        this.showMsg = showMsg;
//    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getShowMsg() {
        return showMsg;
    }

    public void setShowMsg(String showMsg) {
        this.showMsg = showMsg;
    }

    public static void main(String[] args) {
//        Resource resource = new ClassPathResource("beanXMLTest.xml");
//        BeanFactory fa = new XmlBeanFactory(resource);
//        TestBean bean = (TestBean)fa.getBean("testBean");
        ApplicationContext bf = new MyClassPathXmlApplicationContext("beanXMLText.xml");
        TestBean bean = (TestBean)bf.getBean("testBean");
        bean.setShowMsg("测试消息");
        System.out.println(bean.getShowMsg());
    }
}