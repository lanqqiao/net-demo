package com.lqq.demo.spring.aop;

/**
 * @ClassName UserServiceImpl
 * @Description TODO
 * @Author jiebai
 * @Date 2020/7/24 14:19
 * @Version 1.0
 **/
public class UserServiceImpl implements UserService{
    @Override
    public void add() {
        System.out.println("------------------add---------------------");
    }
}
