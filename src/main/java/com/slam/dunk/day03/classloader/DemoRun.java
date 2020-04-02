package com.slam.dunk.day03.classloader;

/**
 * @Author: zerongliu
 * @Date: 3/31/20 21:11
 * @Description:
 */
public class DemoRun {
    public static void main(String[] args) throws Exception {
        DemoCustomClassLoader demoCustomClassLoader = new DemoCustomClassLoader("My ClassLoader");
        Class<?> clazz = demoCustomClassLoader.findClass("com.slam.dunk.App");
        System.out.println(clazz.getClassLoader());
        Object o = clazz.newInstance();
    }
}
