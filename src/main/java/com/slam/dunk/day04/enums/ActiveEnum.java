package com.slam.dunk.day04.enums;

/**
 * @Author: zerongliu
 * @Date: 4/1/20 15:53
 * @Description:
 */
public class ActiveEnum {

    public enum NormalActive {
        PLUS, MINUS, MULTI, DIVIDS, DIFFER;

        double operation(double x, double y) {
            switch (this) {
                case PLUS:
                    return x + y;
                case MINUS:
                    return x - y;
                case MULTI:
                    return x * y;
                case DIVIDS:
                    return x / y;
            }
            throw new UnsupportedOperationException();
        }
    }

    /**
     * we can find the error during compiling phrase
     */
    public enum BetterActive {
        PLUS {
            @Override
            double operation(double x, double y) {
                return x + y;
            }
        }, MINUS {
            @Override
            double operation(double x, double y) {
                return x - y;
            }
        };

        abstract double operation(double x, double y);
    }


    public static void main(String[] args) {

        System.out.println(NormalActive.PLUS.operation(0.1, 0.2));
    }

}
