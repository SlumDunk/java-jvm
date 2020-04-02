package com.slam.dunk.day04.builder.buildpattern;

import com.slam.dunk.day04.builder.buildpattern.product.Person;

/**
 * @Author: zerongliu
 * @Date: 4/1/20 15:53
 * @Description:
 */
public abstract class PersonBuilder {

    /**
     * build components
     */
    public abstract void buildHead();

    public abstract void buildBody();

    public abstract void buildFoot();

    public abstract Person createPerson();

}
