package com.slam.dunk.day01;

/**
 * @Author: zerongliu
 * @Date: 3/30/20 20:50
 * @Description:
 */
public class SimpleHeap {
    private int id;

    public SimpleHeap(int id) {
        super();
        this.id = id;
    }

    public void print() {
        System.out.println("My id is " + id);
    }

    public static void main(String[] args) {
        SimpleHeap s1 = new SimpleHeap(1);
        SimpleHeap s2 = new SimpleHeap(2);
        s1.print();
        s2.print();
    }

}
