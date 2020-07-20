package com.lqq.demo.spring.simplePostProcess;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanDefinitionVisitor;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.util.StringValueResolver;

import java.util.HashSet;
import java.util.Set;

/**
 * @Classname Obscenity
 * @Description TODO
 * @Date 2020/7/20 11:28
 * @Created by lanqq
 */
public class ObscenityRemovingBeanFactoryPostProcessor implements BeanFactoryPostProcessor {
   private Set<String> obscenties;

    public ObscenityRemovingBeanFactoryPostProcessor() {
        this.obscenties = new HashSet<>();
    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        String[] beanNames = beanFactory.getBeanDefinitionNames();
        for (String beanName : beanNames) {
            BeanDefinition bd = beanFactory.getBeanDefinition(beanName);
            StringValueResolver valueResolver = new StringValueResolver() {

                @Override
                public String resolveStringValue(String s) {
                    if (isObscene(s)) {
                        return "***********";
                    }
                    return s;
                }
            };
            BeanDefinitionVisitor visitor = new BeanDefinitionVisitor(valueResolver);
            visitor.visitBeanDefinition(bd);

        }
    }

    public boolean isObscene(Object value) {
        String upperValue = value.toString().toUpperCase();
        return this.obscenties.contains(upperValue);
    }
    public void setObscenties(Set<String> obscenties) {
        this.obscenties.clear();
        for (String obscenty : obscenties) {
            this.obscenties.add(obscenty.toUpperCase());
        }
    }

    public static void main(String[] args) {
        ApplicationContext bf = new ClassPathXmlApplicationContext("simplePostProcess.xml");
        Object simpleBean = bf.getBean("simpleBean");
        System.out.println(simpleBean);
    }
}
