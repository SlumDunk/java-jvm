package com.slam.dunk.day04.enums;

/**
 * @Author: zerongliu
 * @Date: 4/1/20 15:53
 * @Description:
 */
public class SampleIntConst {

    /**
     * state of delayed order
     */
    public static final int ORDER_DEPOT_UN_PAY = 0;
    //public static final String ORDER_DEPOT_UNPAY_DESC = "unpay";
    public static final int ORDER_DEPOT_PAID = 3;
    public static final int ORDER_DEPOT_TIMOUT = 2;

    /**
     * state of logistic order
     */
    public static final int ORDER_LOGISTICS_READY = 0;
    public static final int ORDER_LOGISTICS_TRANSPORT = 1;
    public static final int ORDER_LOGISTICS_ARRIVED = 2;

    /**
     * use enum instead, 0 1 2
     */
    public enum Depot {UN_PAY, PAID, TIMOUT}

    /**
     * use enum instead
     */
    public enum Logistics {READY, TRANSPORT, ARRIVED}

    public static void main(String[] args) {

        System.out.println(Depot.UN_PAY);
        System.out.println(Depot.UN_PAY.ordinal());
//		if(==0)
//			switch status
//			case 0:

    }


}
