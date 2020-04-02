// Wrapper class - uses composition in place of inheritance - Page 84
package com.slam.dunk.day04.countset;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 * @Author: zerongliu
 * @Date: 4/1/20 15:53
 * @Description:
 */
public class CompositionSet<E> {
    private int addCount = 0;
    private final Set<E> s;

    public int getAddCount() {
        return addCount;
    }

    public CompositionSet(Set<E> s) {
        super();
        this.s = s;
    }

    public boolean add(E e) {
        addCount++;
        return s.add(e);
    }

    public boolean addAll(Collection<? extends E> c) {
        addCount = addCount + c.size();
        return s.addAll(c);
    }

    public static void main(String[] args) {
        CompositionSet<String> s = new CompositionSet<>(new HashSet<String>());
        s.addAll(Arrays.asList("Mark", "James", "Lison"));
        System.out.println(s.getAddCount());
    }
}
