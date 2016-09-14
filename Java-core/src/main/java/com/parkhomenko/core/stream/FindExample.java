package com.parkhomenko.core.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * @author Dmytro Parkhomenko
 *         Created on 14.09.16.
 */

public class FindExample {
    public static void main(String[] args) {
        List<Integer> A = Arrays.asList(1, 2, 3, 4);

        Optional<Integer> integerOptional = A.stream().filter(curr -> curr > 2).findAny();

        System.out.println(integerOptional.isPresent() ? integerOptional.get() : "none");
    }
}
