package com.parkhomenko.core.stream;

import java.util.Arrays;
import java.util.List;

/**
 * @author Dmytro Parkhomenko
 *         Created on 14.09.16.
 */

public class SummaExample {
    public static void main(String[] args) {
        List<Integer> integerList = Arrays.asList(1, 2, 3, 4, 5);

        int result = integerList.stream().reduce(0, Integer::sum);

        System.out.println(result);
    }
}
