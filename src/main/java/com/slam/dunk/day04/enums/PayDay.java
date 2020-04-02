package com.slam.dunk.day04.enums;

/**
 * @Author: zerongliu
 * @Date: 4/1/20 15:53
 * @Description:
 */
enum PayDay {
    MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY, LABOR;

    private static final int HOURS_WORK = 2;
    private static final int HOURS_REST = 3;

    /**
     *
     * @param hoursOvertime
     * @return
     */
    double pay(double hoursOvertime) {
        switch (this) {
            case SATURDAY:
            case SUNDAY:
                return hoursOvertime * HOURS_REST;
            default:
                return hoursOvertime * HOURS_WORK;
        }
    }


}
