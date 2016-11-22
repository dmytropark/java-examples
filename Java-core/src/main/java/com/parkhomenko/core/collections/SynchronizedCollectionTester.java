package com.parkhomenko.core.collections;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;

/**
 * @author Dmytro Parkhomenko
 *         Created on 28.09.16.
 */

public class SynchronizedCollectionTester {
    public static void main(String[] args) {
        Collection<String> c = Collections.synchronizedCollection(new HashSet<String>());

        c.add("test");
        c.add("test");

        System.out.println(c.size());
    }
}
