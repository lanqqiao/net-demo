package com.lqq.demo.test;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

public class UnSafeTest {

    Unsafe getUnSafe () throws NoSuchFieldException, IllegalAccessException {
        Field f = Unsafe.class.getDeclaredField("theUnsafe");
        f.setAccessible(true);
        Unsafe unsafe = (Unsafe) f.get(null);
        return unsafe;
    }
}
