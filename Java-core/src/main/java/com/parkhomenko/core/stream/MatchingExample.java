package com.parkhomenko.core.stream;

import java.util.Arrays;
import java.util.List;

/**
 * @author Dmytro Parkhomenko
 *         Created on 14.09.16.
 */

public class MatchingExample {
    public static void main(String[] args) {
        List<Integer> A = Arrays.asList(1, 2, 3, 4);

        boolean result = A.stream().allMatch(value -> value > 10);

        System.out.println(result);

        boolean result2 = A.stream().noneMatch(value -> value > 10);

        System.out.println(result2);
    }
}
