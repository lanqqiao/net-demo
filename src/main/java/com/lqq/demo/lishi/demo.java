package com.lqq.demo.lishi;

import com.google.common.collect.Lists;

import java.util.Collections;
import java.util.List;

public class demo {
    public void main1(String[] args){
        System.out.println("父类的运行结果");
        A a=new A();
        a.fun(1,2);
        //父类存在的地方，可以用子类替代
        //子类B替代父类A
        System.out.println("子类替代父类后的运行结果");
        B b=new B();
        b.fun(1,2);
    }

    public static void main(String[] args) {
        List<String> list = Lists.newArrayList();
        list.add("abc");
        list.add("ab2");
        list.add("ab3");
        list.add("ab4");
        list.add("ab5");
        list.add("abc");
        List<String> list2 = Lists.newArrayList();
        list2.add("ab2");
        list2.add("abc");
        System.out.println(list);
        Collections.rotate(list, -3);
        System.out.println(list);
    }
}