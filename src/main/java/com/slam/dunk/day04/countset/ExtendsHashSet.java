package com.slam.dunk.day04.countset;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;

/**
 * @Author: zerongliu
 * @Date: 4/1/20 15:53
 * @Description:
 */
public class ExtendsHashSet<E> extends HashSet<E> {
    /**
     * counter
     */
    private int addCount = 0;

    public ExtendsHashSet() {
    }

    @Override
    public boolean add(E e) {
        addCount++;
        return super.add(e);
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        addCount = addCount + c.size();
        return super.addAll(c);
    }

    public int getAddCount() {
        return addCount;
    }

    public static void main(String[] args) {
        ExtendsHashSet<String> s = new ExtendsHashSet<String>();
        s.addAll(Arrays.asList("Mark", "James", "Lison"));
        //6
        System.out.println(s.getAddCount());
    }
}
