package com.parkhomenko.core.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Dmytro Parkhomenko
 *         Created on 10.09.16.
 */

public class ArrayListTester {
    public static void main(String[] args) {
        List<String> stringList = new ArrayList<>();
        stringList.add("test");
        String[] stringArray = stringList.toArray(new String[10]);
        System.out.println(Arrays.toString(stringArray));


        //
        List<Integer> integerList = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20));
        integerList.add(21);
    }
}
