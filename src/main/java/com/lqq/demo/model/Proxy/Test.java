package com.lqq.demo.model.Proxy;

//测试
public class Test {

    public static void main(String[] args) {
        ProxySubject proxySubject = new ProxySubject(new RealSubject());
        proxySubject.visit();
    }
}