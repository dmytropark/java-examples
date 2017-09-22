package com.parkhomenko.core.collections;

import java.util.Arrays;
import java.util.List;

public class FindElementInArray {

    public static void main(String[] args) {
        Integer[] array = {1, 2, 3};
        List<Integer> list = Arrays.asList(array);
        list.set(0, 4);
        list.add(5);

        for (Integer anArray : array) {
            System.out.println("After array = " + anArray);
        }
    }
}
