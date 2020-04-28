package com.lqq.demo.classical.classinit;

/**
 * 1，初始化子类之前先初始化父类 (5) (1)
 * 2，初始化子类 (10) (6)
 * 3，实例化子类
 *      1）super() （最前）      （9）（3）（2）
 *      2) i = test()            （9）
 *      3)子类的非静态块         （8）
 *      4）构造器（最后）         （7）
 */
public class Son extends Father {

    private int i = test();
    private static int j = method();

    static {
        System.out.print("(6)");
    }

    Son() {
        System.out.print("(7)");
    }

    {
        System.out.print("(8)");
    }
    public int test() {
        System.out.print("(9)");
        return 1;
    }

    public static int method() {
        System.out.print("(10)");
        return 1;
    }

    public static void main(String[] args) {
        Son s1 = new Son();
        System.out.println();
//        Son s2 = new Son();
    }
}
