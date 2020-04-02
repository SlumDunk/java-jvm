package com.slam.dunk.day04.createobj;

/**
 * @Author: zerongliu
 * @Date: 4/1/20 15:53
 * @Description:
 */
public class Sum {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();

        //long sum=0;
        //object
        Long sum = 0L;
        //always auto boxing and unboxing
        for (long i = 0; i < Integer.MAX_VALUE; i++) {
            sum = sum + i;
            //new instance
        }

        System.out.println("spend time:" + (System.currentTimeMillis() - start) + "ms");
    }
}
