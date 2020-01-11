package com.parkhomenko.data_structures_coding_intervirew_algorithms;

import java.util.Arrays;
import java.util.List;

public class GenericIssue {

    static class Pair<T> {
        private final T first;
        private final T second;

        public Pair(T first, T second) {
            this.first = first;
            this.second = second;
        }

        public List<String> stringList() {
            return Arrays.asList(String.valueOf(first), String.valueOf(second));
        }
    }

    public static void main(String[] args) {
        Pair p = new Pair<Object>(23, "skiddo");

        System.out.println(p.first + " " + p.second);

//        for (String s : p.stringList()) {
//            System.out.println(s + " ");
//        }
    }
}
