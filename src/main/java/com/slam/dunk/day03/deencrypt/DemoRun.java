package com.slam.dunk.day03.deencrypt;

/**
 * @Author: zerongliu
 * @Date: 3/31/20 21:49
 * @Description:
 */
public class DemoRun {
    public static void main(String[] args) throws Exception {
        CustomClassLoader demoCustomClassLoader
                = new CustomClassLoader("My ClassLoader");
        demoCustomClassLoader.setBasePath("target/classes/");
        Class<?> clazz =
                demoCustomClassLoader.findClass("com.slam.dunk.App");
        System.out.println(clazz.getClassLoader());
        Object o = clazz.newInstance();
        System.out.println(o);
    }
}
