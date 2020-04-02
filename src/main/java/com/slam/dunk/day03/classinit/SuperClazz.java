package com.slam.dunk.day03.classinit;

/**
 * @Author: zerongliu
 * @Date: 3/31/20 20:35
 * @Description:
 */
public class SuperClazz {
    static {
        System.out.println("SuperClass init!");
    }

    public static int value = 123;
    public static final String HELLO_WORLD = "hello,world";
    public static final int WHAT = value;
}
