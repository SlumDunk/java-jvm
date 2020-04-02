package com.slam.dunk.day04.builder.buildpattern;


import com.slam.dunk.day04.builder.buildpattern.product.Person;
import com.slam.dunk.day04.builder.buildpattern.product.Woman;

/**
 * @Author: zerongliu
 * @Date: 4/1/20 15:53
 * @Description:
 */
public class WomanBuilder extends PersonBuilder {

    private Person person;

    public WomanBuilder() {
        this.person = new Woman();
    }

    @Override
    public void buildHead() {
        person.setHead("Pretty Head");

    }

    @Override
    public void buildBody() {
        person.setBody("soft body");

    }

    @Override
    public void buildFoot() {
        person.setFoot("long white foot");

    }

    @Override
    public Person createPerson() {
        return person;
    }


}
