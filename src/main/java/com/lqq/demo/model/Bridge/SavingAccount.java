package com.lqq.demo.model.Bridge;

//活期账号
public class SavingAccount implements Account{

    @Override
    public Account openAccount() {
        System.out.println("打开活期账号");
        return new SavingAccount();
    }

    @Override
    public void showAccount() {
        System.out.println("这是一个活期账号");
    }
}