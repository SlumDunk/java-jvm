package com.slam.dunk.day03.parse;

/**
 * @Author: zerongliu
 * @Date: 3/31/20 23:43
 * @Description:
 */
public class StaticDispatch {
    static abstract class Human {
    }

    static class Man extends Human {
    }

    static class Woman extends Human {
    }

    public void sayHello(Human guy) {
        //1
        System.out.println("hello,guy！");
    }

    public void sayHello(Man guy) {
        //2
        System.out.println("hello,gentleman！");
    }

    public void sayHello(Woman guy) {
        //3
        System.out.println("hello,lady！");
    }

    public static void main(String[] args) {

        Human h1 = new Man();
        Human h2 = new Woman();

        StaticDispatch sr = new StaticDispatch();
        //print 1, static dispatch, according to the static type of the variable
        sr.sayHello(h1);
        sr.sayHello(h2);


    }
}
