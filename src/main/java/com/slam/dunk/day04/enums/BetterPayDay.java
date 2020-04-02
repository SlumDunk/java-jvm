package com.slam.dunk.day04.enums;

/**
 * @Author: zerongliu
 * @Date: 4/1/20 15:53
 * @Description:
 */
public enum BetterPayDay {
    MONDAY(PayType.WORK), TUESDAY(PayType.WORK), WEDNESDAY(
            PayType.WORK), THURSDAY(PayType.WORK), FRIDAY(PayType.WORK),
    SATURDAY(PayType.REST), SUNDAY(PayType.REST), WUYI(PayType.REST);

    /**
     * field
     */
    private final PayType payType;

    BetterPayDay(PayType payType) {
        this.payType = payType;
    }

    double pay(double hoursOvertime) {
        return payType.pay(hoursOvertime);
    }

    /**
     * strategy enum
     */
    private enum PayType {
        WORK {
            @Override
            double pay(double hoursOvertime) {
                return hoursOvertime * HOURS_WORK;
            }
        },
        REST {
            @Override
            double pay(double hoursOvertime) {
                return hoursOvertime * HOURS_REST;
            }
        };

        private static final int HOURS_WORK = 2;
        private static final int HOURS_REST = 3;

        /**
         * @param hoursOvertime
         * @return
         */
        abstract double pay(double hoursOvertime);
    }

    public static void main(String[] args) {
        System.out.println(BetterPayDay.MONDAY.pay(7.5));
    }
}
