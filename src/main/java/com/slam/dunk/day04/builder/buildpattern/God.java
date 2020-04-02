package com.slam.dunk.day04.builder.buildpattern;


import com.slam.dunk.day04.builder.buildpattern.product.Person;

/**
 * @Author: zerongliu
 * @Date: 4/1/20 15:53
 * @Description: Director
 */
public class God {

    public Person buildPerson(PersonBuilder pb) {
        pb.buildHead();
        pb.buildBody();
        pb.buildFoot();
        return pb.createPerson();
    }

}
