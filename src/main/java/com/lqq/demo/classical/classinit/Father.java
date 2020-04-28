package com.lqq.demo.classical.classinit;

/**
 * 初始化顺序
 * （1)静态变量j = method()  (5)
 *  (2)静态代码块 (1)
 *
 * super方法：
 *  (1) i = test()
 *  (2) 非静态代码块
 *  (3) 构造器
 */
public class Father {
    private int i = test();
    private static int j = method();

    static {
        System.out.print("(1)");
    }
    Father() {
        System.out.print("(2)");
    }
    {
        System.out.print("(3)");
    }
    public int test() {
        System.out.print("(4)");
        return 1;
    }

    public static int method() {
        System.out.print("(5)");
        return 1;
    }


}
