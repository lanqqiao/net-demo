package com.lqq.demo.spring;

import com.lqq.demo.spring.application.MyClassPathXmlApplicationContext;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

@Component
public class TestBean implements BeanFactoryAware, ApplicationContextAware {

    UserService userService;

    public String showMsg;

    public String name;

    public String psw;

    private ApplicationContext applicationContext;

    private BeanFactory beanFactory;

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

    public String getPsw() {
        return psw;
    }

    public void setPsw(String psw) {
        this.psw = psw;
    }

    @Override
    public String toString() {
        return "TestBean{" + "userService=" + userService + ", showMsg='" + showMsg + '\'' + ", name='" + name + '\''
            + ", psw='" + psw + '\'' + '}';
    }

    public static void main(String[] args) {
//        Resource resource = new ClassPathResource("beanXMLTest.xml");
//        BeanFactory fa = new XmlBeanFactory(resource);
//        TestBean bean = (TestBean)fa.getBean("testBean");
        ApplicationContext bf = new ClassPathXmlApplicationContext("beanXMLText.xml");
        TestBean bean = (TestBean)bf.getBean("testBean");
        bean.setShowMsg("测试消息");
        System.out.println(bean.getShowMsg());
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.beanFactory = beanFactory;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}