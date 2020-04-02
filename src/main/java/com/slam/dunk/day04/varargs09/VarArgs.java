package com.slam.dunk.day04.varargs09;

import java.util.Collections;

/**
 * @Author: zerongliu
 * @Date: 4/1/20 15:53
 * @Description:
 */
public class VarArgs {

    public static void userOder(int count) {
        if (count < 0) {
            throw new IllegalArgumentException("");
        }
    }

    /**
     * the number of args is 0 or more
     *
     * @param args
     * @return
     */
    static int sum(int... args) {
        int sum = 0;
        for (int arg : args) {
            sum += arg;
        }
        return sum;
    }

    /**
     * 1 or more
     *
     * @param args
     * @return
     */
    static int sum1(int... args) {
        if (args.length == 0) {
            //handle exception
        }
        if (args[0] == 100) {

        }
        int sum = 0;
        for (int i = 1; i < args.length; i++) {
            sum += args[i];
        }
        return sum;
    }

    static int sum2(int flag, int... args) {
        if (flag == 100) {

        }
        int sum = 0;
        for (int arg : args) {
            sum += arg;
        }
        return sum;
    }


}
