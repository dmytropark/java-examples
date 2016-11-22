package com.parkhomenko.algorithm_problems;

/**
 * @author Dmytro Parkhomenko
 *         Created on 15.09.16.
 */

/**
 *
 1. Вам необходимо реализовать функцию, которая бы проверяла число на четность,
    используя только битовые операции AND, OR, NOT. Разбор решения:
 */

public class EvenBitAlgorithm {
    public static void main(String[] args) {
        System.out.println(isEven(10));
        System.out.println(isEven(11));
//        System.out.println(isEven(1.1));
//        System.out.println(isEven(1.0));
        System.out.println(isEven(5));
        System.out.println(isEven(0));
    }

    public static boolean isEven(int number) {
        return (number & 1) == 0;
    }

//    public static boolean isEven(double number) {
//        return Double.longBitsToDouble(Double.doubleToLongBits(number) & 0x00000001) == 0;
//    }
}
