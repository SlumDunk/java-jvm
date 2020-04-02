package com.slam.dunk.day04.stringunion;

/**
 * @Author: zerongliu
 * @Date: 4/1/20 15:53
 * @Description:
 */
public class Test {
    private static class Log {


        public static void debug(String msg) {
            if (isDebug()) {
                System.out.println(msg);
            }
        }

        public static boolean isDebug() {
            return false;

        }
    }

    /**
     * 40000:1 performance
     *
     * @param args
     */
    public static void main(String[] args) {
        int count = 100000000;
        long start = System.currentTimeMillis();
//        StringBuilder
//        StringBuffer;
//        "a"+"b"+"";
        for (int i = 0; i < count; i++) {

            Log.debug("The system is running and the time is "
                    + System.currentTimeMillis()
                    + " now,Let's do another thing:" + System.nanoTime());

        }
        System.out.println("print directly, count：" + count + "：spend time :"
                + (System.currentTimeMillis() - start) + "ms");

        start = System.currentTimeMillis();
        for (int i = 0; i < count; i++) {
            if (Log.isDebug()) {
                Log.debug("The system is running and the time is "
                        + System.currentTimeMillis()
                        + " now,Let's do another thing:" + System.nanoTime());
            }
        }
        System.out.println("judge first, then print, count：" + count + "：spend time :"
                + (System.currentTimeMillis() - start) + "ms");


    }
}
