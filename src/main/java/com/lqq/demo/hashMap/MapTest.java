package com.lqq.demo.hashMap;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName MapTest
 * @Description TODO
 * @Author jiebai
 * @Date 2019/12/2 11:08
 * @Version 1.0
 **/
public class MapTest {

    /**
     * The default initial capacity - MUST be a power of two.
     */
    static final int DEFAULT_INITIAL_CAPACITY = 1 << 4; // aka 16

    /**
     * The maximum capacity, used if a higher value is implicitly specified
     * by either of the constructors with arguments.
     * MUST be a power of two <= 1<<30.
     */
    static final int MAXIMUM_CAPACITY = 1 << 30;

    public static void main(String[] args) {
        System.out.println(tableSizeFor(10000));
        System.out.println(tableSizeFor(10));

    }

    /**
     * 测试何时扩容
     * @param size
     */
    static void testSize(int size) {
        Map<Integer, Object> map = new HashMap<>(size);
        for (int i = 0; i < size; i++) {
            System.out.println(i);
            map.put(i, i);
        }
    }

    static final int tableSizeFor(int cap) {
        int n = cap - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        return (n < 0) ? 1 : (n >= MAXIMUM_CAPACITY) ? MAXIMUM_CAPACITY : n + 1;
    }


}
