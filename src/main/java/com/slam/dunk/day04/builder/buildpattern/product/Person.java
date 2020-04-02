package com.slam.dunk.day04.builder.buildpattern.product;


/**
 * @Author: zerongliu
 * @Date: 4/1/20 15:53
 * @Description:
 */
public abstract class Person {

    protected String head;
    protected String body;
    protected String foot;

    public String getHead() {
        return head;
    }

    public void setHead(String head) {
        this.head = head;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getFoot() {
        return foot;
    }

    public void setFoot(String foot) {
        this.foot = foot;
    }
}
