package com.lqq.demo.spring;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class TestBean {
    public String showMsg;

    public TestBean(String showMsg) {
        this.showMsg = showMsg;
    }

    public String getShowMsg() {
        return showMsg;
    }

    public void setShowMsg(String showMsg) {
        this.showMsg = showMsg;
    }

    public static void main(String[] args) {
        Resource resource = new ClassPathResource("beanXMLTest.xml");
        BeanFactory fa = new XmlBeanFactory(resource);
        TestBean bean = (TestBean)fa.getBean("testBean");
        bean.setShowMsg("测试消息");
        System.out.println(bean.getShowMsg());
    }
}