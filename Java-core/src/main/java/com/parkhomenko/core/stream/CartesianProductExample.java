package com.parkhomenko.core.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Dmytro Parkhomenko
 *         Created on 14.09.16.
 */

public class CartesianProductExample {
    public static void main(String[] args) {
        List<Integer> A = Arrays.asList(1, 2, 3, 4);
        List<Integer> B = Arrays.asList(5, 6);

        List<int[]> result = A.stream()
                .flatMap(i -> B.stream()
                                    .map(j ->  new int[] {i, j}))
                .collect(Collectors.toList());

        result.forEach(ints -> System.out.println(Arrays.toString(ints)));
    }
}
