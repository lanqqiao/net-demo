package com.lqq.demo.model.Bridge;

//工商银行
public class ICBCBank extends Bank {


    public ICBCBank(Account account) {
        super(account);
    }

    @Override
    Account openAccount() {
        System.out.println("打开中国工商银行账号");
        //这里要注意委托实现
        account.openAccount();
        return account;
    }
}