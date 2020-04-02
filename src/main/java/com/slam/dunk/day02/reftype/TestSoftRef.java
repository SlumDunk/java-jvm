package com.slam.dunk.day02.reftype;

import java.lang.ref.SoftReference;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author: zerongliu
 * @Date: 3/30/20 23:42
 * @Description:
 */
public class TestSoftRef {
    public static class User {
        public int id = 0;
        public String name = "";

        public User(int id, String name) {
            super();
            this.id = id;
            this.name = name;
        }

        @Override
        public String toString() {
            return "User [id=" + id + ", name=" + name + "]";
        }

    }

    public static void main(String[] args) {

        User u = new User(1, "Mark");
        SoftReference<User> userSoft = new SoftReference<>(u);
        //only userSoft point to the instance
        u = null;

        System.out.println(userSoft.get());
        //userSoft may not be recycled
        System.gc();
        System.out.println("AfterGc");
        //
        System.out.println(userSoft.get());
        List<byte[]> list = new LinkedList<>();

        try {
            for (int i = 0; i < 100; i++) {
                //check whether it is recycled or not
                System.out.println("********************" + userSoft.get());
                list.add(new byte[1024 * 1024 * 1]);
            }
        } catch (Throwable e) {
            //after OOM, it is recycled
            System.out.println("Throwable********************" + userSoft.get());
        }

    }
}
