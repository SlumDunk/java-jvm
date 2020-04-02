package com.slam.dunk.day01;

/**
 * @Author: zerongliu
 * @Date: 3/30/20 22:45
 * @Description:
 */
public class StackOOM {
    private int stackLength = 1;

    private void recursive(int x, String y) {
        stackLength++;
        recursive(x, y);
    }

    public static void main(String[] args) {
        StackOOM oom = new StackOOM();
        try {
            oom.recursive(12, "Mark");
        } catch (Throwable e) {
            System.out.println("stackLength = " + oom.stackLength);
            e.printStackTrace();
        }
    }
}
