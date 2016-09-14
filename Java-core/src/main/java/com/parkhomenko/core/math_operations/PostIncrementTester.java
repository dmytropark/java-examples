package com.parkhomenko.core.math_operations;


import java.util.Arrays;

/**
 * @author Dmytro Parkhomenko
 *         Created on 12.09.16.
 */

public class PostIncrementTester {
    public static void main(String[] args) {
        int[] test = { 0, 1};
        int index = 0;
        test[index++] = 2;

        System.out.println(Arrays.toString(test));
        System.out.println(index);

    }
}
