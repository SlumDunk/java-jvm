package com.slam.dunk.day04.builder.buildpattern;

/**
 * @Author: zerongliu
 * @Date: 4/1/20 15:53
 * @Description: Client Company
 */
public class Fate {

    public static void main(String[] args) {
        System.out.println("create God");
        God god = new God();
        god.buildPerson(new ManBuilder());
        god.buildPerson(new WomanBuilder());

    }
}
