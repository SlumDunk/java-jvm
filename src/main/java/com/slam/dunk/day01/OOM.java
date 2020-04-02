package com.slam.dunk.day01;

import java.util.LinkedList;
import java.util.List;

/**
 * @Author: zerongliu
 * @Date: 3/30/20 22:33
 * @Description:
 */
public class OOM {
    public static void main(String[] args) {

//        List<Object> list = new LinkedList<>();
//        int i = 0;
//        while (true) {
//            i++;
//            if (i % 10000 == 0) {
//                System.out.println("i=" + i);
//            }
//            list.add(new Object());
//        }

		String[] strings = new String[100000000];
    }
}
