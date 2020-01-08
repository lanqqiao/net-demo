package com.lqq.demo.model.Proxy;

//代理类
public class ProxySubject implements Subject{

    private Subject subject;


    public ProxySubject(Subject subject){
        this.subject =subject;
    }

    @Override
    public void visit() {
        subject.visit();
    }
}
