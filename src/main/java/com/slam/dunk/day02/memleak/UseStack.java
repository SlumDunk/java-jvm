package com.slam.dunk.day02.memleak;

/**
 * @Author: zerongliu
 * @Date: 3/31/20 16:17
 * @Description:
 */
public class UseStack {
    public static void main(String[] args) {
        MyStack stack = new MyStack();
        Object o = new Object();
        System.out.println("o=" + o);
        stack.push(o);
        Object o1 = stack.pop();
        System.out.println("o1=" + o1);

        System.out.println(stack.elements[0]);

    }
}
