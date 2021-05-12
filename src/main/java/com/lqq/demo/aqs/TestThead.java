package com.lqq.demo.aqs;

import com.google.common.collect.Lists;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

/**
 * @ClassName TestThead
 * @Description TODO
 * @Author jiebai
 * @Date 2021/4/29 14:26
 * @Version 1.0
 **/
public class TestThead {

    private static final int CORE_POOL_SIZE = 5;
    private static final int MAX_POOL_SIZE = 10;
    private static final int QUEUE_CAPACITY = 100;
    private static final Long KEEP_ALIVE_TIME = 1L;

    static List<PendingOrderDTO> list = Lists.newLinkedList();

    public static void main(String[] args) throws ExecutionException, InterruptedException,
        UnsupportedEncodingException {
        int xmlLength = 1249484575;
        String ss = "xxxxxxxxxxx";
        byte[] bytes = ss.getBytes();
        String xmlContent = new String(Arrays.copyOfRange(bytes, 20, 20 + xmlLength), "UTF-8");
        System.out.println(xmlContent);
    }


    static class Task implements Callable<String> {

        @Override
        public String call() throws Exception {
            Thread.sleep(10l);
            for (int i = 0; i < 999999999999l ; i++) {
                list.add(new PendingOrderDTO());
                System.out.println("i");
            }
            return "xxxxx";
        }
    }

}
