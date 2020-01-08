package com.lqq.demo.model.Bridge;

//农业银行
public class ABCBank extends Bank{


    public ABCBank(Account account) {
        super(account);
    }

    @Override
    Account openAccount() {
        System.out.println("打开中国农业银行账号");
        //这里要注意委托实现
        account.openAccount();
        return account;
    }
}