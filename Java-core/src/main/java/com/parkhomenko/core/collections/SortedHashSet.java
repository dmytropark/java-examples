package com.parkhomenko.core.collections;

import java.util.Iterator;
import java.util.NavigableSet;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * @author Dmytro Parkhomenko
 *         Created on 13.09.16.
 */

public class SortedHashSet {
    public static void main(String[] args) {
        NavigableSet<Integer> navigableSet = new TreeSet<>();
        navigableSet.add(1);
        navigableSet.add(5);
        navigableSet.add(4);
        navigableSet.add(2);

        print(navigableSet);

        System.out.println("---------------------------");

        System.out.println(navigableSet.ceiling(5));
        System.out.println(navigableSet.higher(5));
        System.out.println(navigableSet.floor(3));

        System.out.println(navigableSet.pollFirst());

        print(navigableSet);

        NavigableSet<Integer> descSet = navigableSet.descendingSet();

        print(descSet);

        Iterator<Integer> descItr = descSet.iterator();


        for(Iterator<Integer> itr = navigableSet.iterator(); itr.hasNext();) {
            int curr = itr.next();
            if (curr == 2) {
                descItr.next();
//                descItr.remove(); // Exception in thread "main" java.util.ConcurrentModificationException
            }
        }

        print(navigableSet);
        print(descSet);


        SortedSet<Integer> set = navigableSet.headSet(10);
        print(set);

    }

    private static void print(SortedSet<Integer> navigableSet) {
        System.out.println("---------------------print ------");

        for(Iterator<Integer> itr = navigableSet.iterator(); itr.hasNext();) {
            int curr = itr.next();
            System.out.println(curr);
        }
    }
}
