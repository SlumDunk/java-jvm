package com.slam.dunk.day02.memleak;

/**
 * @Author: zerongliu
 * @Date: 3/31/20 16:16
 * @Description:
 */
public class MyStack {
    public Object[] elements;
    private int size = 0;

    private static final int Cap = 16;

    public MyStack() {
        elements = new Object[Cap];
    }


    public void push(Object e) {
        elements[size] = e;
        size++;
    }


    public Object pop() {
        size = size - 1;
        Object o = elements[size];
        //if we don't set it as null, it will cost memory leak
        elements[size] = null;
        return o;
    }
}
