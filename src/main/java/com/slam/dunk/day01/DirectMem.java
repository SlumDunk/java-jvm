package com.slam.dunk.day01;

import java.nio.ByteBuffer;

/**
 * @Author: zerongliu
 * @Date: 3/30/20 23:11
 * @Description:
 */
public class DirectMem {
    public static void main(String[] args) {
        ByteBuffer b = ByteBuffer.allocateDirect(1024 * 1024 * 14);
    }
}
