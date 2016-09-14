package com.parkhomenko.core.stream;


import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Dmytro Parkhomenko
 *         Created on 14.09.16.
 */

public class UniqueCharsExample {
    public static void main(String[] args) {
        String exp1 = "Hello";
        String exp2 = "Worldw";
        String[] array = {exp1, exp2};

        List<String> list = Arrays.stream(array)
                .map(word -> word.split(""))
                .flatMap(Arrays::stream)
                .map(String::toLowerCase)
                .distinct()
                .collect(Collectors.toList());

        System.out.println(list);
    }
}
