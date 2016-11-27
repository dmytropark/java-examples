package com.parkhomenko.algorithm_problems;

/**
 * @author Dmytro Parkhomenko
 *         Created on 25.11.16.
 */

public class RecursionTask {

    public static String func(int a, int b) {

        if(a == b) {
            return String.valueOf(a);
        }

        if(a < b)
            return func(a, b-1) + " " + b;
        else
            return a + " " + func(a-1, b);
    }

    public static void main(String[] args) {
        System.out.println(RecursionTask.func(1, 5));
        System.out.println(RecursionTask.func(5, 1));
    }
}
