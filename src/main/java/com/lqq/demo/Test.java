package com.lqq.demo;

import java.nio.channels.SelectionKey;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @ClassName Test
 * @Description TODO
 * @Author jiebai
 * @Date 2019/11/23 18:05
 * @Version 1.0
 **/
public class Test {


    public static void main(String[] args) {
        int interestSet = SelectionKey.OP_READ | SelectionKey.OP_WRITE;
        System.out.println(interestSet);

    }

}
