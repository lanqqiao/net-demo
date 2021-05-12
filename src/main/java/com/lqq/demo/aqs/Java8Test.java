package com.lqq.demo.aqs;

import java.util.*;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;

/**
 * @ClassName AQSTest
 * @Description TODO
 * @Author jiebai
 * @Date 2021/4/26 14:22
 * @Version 1.0
 **/
public class Java8Test extends AbstractQueuedSynchronizer {

    public static void main(String[] args) {
        List<String> names = Arrays.asList("peter", "anna", "mike", "xenia");
        Collections.sort(names, (o1, o2) -> {
            return o1.compareTo(o2);
        });
        names.sort((o1, o2) -> o1.compareTo(o2));
    }

    void abc() {
        Stack<Integer> stack1 = new Stack<Integer>();
        stack1.push(1);


    }
}
