package com.slam.dunk.day04.enums;

/**
 * @Author: zerongliu
 * @Date: 4/1/20 15:53
 * @Description:
 */
public enum DepotEnum {
    UN_PAY(0, "un pay"), PAID(1, "paid"), TIMOUT(-1, "time out");

    private int status;
    private String desc;
    /**
     * other field
     */
    private String dbInfo;

    private DepotEnum(int status, String desc) {
        this.status = status;
        this.desc = desc;
    }

    public int getStatus() {
        return status;
    }

    public String getDesc() {
        return desc;
    }

    public String getDbInfo() {
        return dbInfo;
    }

    public int calcStatus(int params) {
        return status + params;
    }

    public static void main(String[] args) {
        for (DepotEnum e : DepotEnum.values()) {
            System.out.println(e + ":" + e.calcStatus(14));
        }
    }


}
