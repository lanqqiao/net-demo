package com.lqq.demo.model.Proxy;

//真实类
public class RealSubject implements Subject{

    private String name = "juju";

    @Override
    public void visit() {
        System.out.println(name);
    }
}
