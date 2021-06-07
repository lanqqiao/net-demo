package com.lqq.demo.spring.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName AspectJTest
 * @Description TODO
 * @Author jiebai
 * @Date 2020/7/22 12:29
 * @Version 1.0
 **/
@Aspect
public class AspectJTest {

    @Pointcut("execution(* *.test(..))")
//    @Pointcut("execution(* *(..))")
    public void test() {

    }

    @Before("test()")
    public void beforeTest() {
        System.out.println("beforeTest");
    }

    @After("test()")
    public void afterTest() {
        System.out.println("afterTest");
    }

    @Around("test()")
    public Object arountTest(ProceedingJoinPoint p) {
        System.out.println("before1");
        Object o = null;
        try {
            o = p.proceed();
        } catch (Throwable e) {
            e.printStackTrace();
        }
        System.out.println("after1");
        return o;
    }

    public static void main(String[] args) {

        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext();
        ac.register(SpringAOPconfig.class);
//        ac.scan("com.lqq.demo.spring.aop");
        ac.refresh();
        AopTestBean bean = ac.getBean(AopTestBean.class);
        System.out.println(bean.test(1, 2));

    }

}
