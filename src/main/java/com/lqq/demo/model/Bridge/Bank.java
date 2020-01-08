package com.lqq.demo.model.Bridge;

//银行抽象类
public abstract class Bank {

    protected Account account;

    public Bank(Account account){
        this.account = account;
    }

    abstract Account openAccount();
}