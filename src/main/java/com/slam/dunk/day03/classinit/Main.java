package com.slam.dunk.day03.classinit;

/**
 * @Author: zerongliu
 * @Date: 3/31/20 20:36
 * @Description:
 */
public class Main {

    public static void main(String[] args) {
        //only SuperClazz will be initialized
        //System.out.println(SubClazz.value);
        //no initialization
        //SuperClazz[] sca = new SuperClazz[10];
        //no initialization, constant pool, propagation optimization
        //System.out.println(SubClazz.HELLO_WORLD);
        //only SuperClazz will be initialized, not propagation for int value
        System.out.println(SubClazz.WHAT);

    }

}
