package com.lqq.demo.spring.aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @ClassName MyInvocationHandler
 * @Description TODO
 * @Author jiebai
 * @Date 2020/7/24 14:19
 * @Version 1.0
 **/
public class MyJDKInvocationHandler implements InvocationHandler {

    public Object target;

    public MyJDKInvocationHandler(Object target) {
        super();
        this.target = target;
    }

    @Override
    public Object invoke(Object o, Method method, Object[] objects) throws Throwable {
        System.out.println("----------before----------------");
        Object result = method.invoke(target, objects);
        System.out.println("----------------after------------");
        return result;
    }

    public Object getProxy() {
        return Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(),
            target.getClass().getInterfaces(), this);
    }

    public static void main(String[] args) {
        UserService userService = new UserServiceImpl();
        MyJDKInvocationHandler invocationHandler = new MyJDKInvocationHandler(userService);
        UserService proxy = (UserService)invocationHandler.getProxy();
        proxy.add();
    }
}
