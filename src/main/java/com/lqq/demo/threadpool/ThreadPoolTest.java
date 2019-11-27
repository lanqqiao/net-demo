package com.lqq.demo.threadpool;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @ClassName ThreadPoolTest
 * @Description TODO
 * @Author jiebai
 * @Date 2019/11/26 13:55
 * @Version 1.0
 **/
public class ThreadPoolTest {

//    final static int cpuCount =  Runtime.getRuntime().availableProcessors();

    static ThreadPoolExecutor pool = new ThreadPoolExecutor(2, 20, 10, TimeUnit.SECONDS,
        new LinkedBlockingDeque<>(800), new ThreadPoolExecutor.CallerRunsPolicy());

    static AtomicInteger tCnt = new AtomicInteger(0);

    public static void main(String[] args){
        System.out.println(Runtime.getRuntime().availableProcessors());

//        tasks ：每秒的任务数，假设为1000
//        taskcost：每个任务花费时间，假设为0.01s
//        responsetime：系统允许容忍的最大响应时间，假设为1s

        while (tCnt.get() < 1000) {
            tCnt.incrementAndGet();
            pool.submit(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    Thread thread = Thread.currentThread();
                    String name = thread.getName();
                    int activeCount = pool.getActiveCount();
                    System.out.println(
                        "任务：" + (tCnt.get()) + "-----,线程名称:" + name + "-----活跃线程数:" + activeCount +
                            "，----队列数量" + pool.getQueue().size());
                }
            });
        }
        System.out.println(tCnt);
    }

}
