package com.parkhomenko.algorithm_problems;

/**
 * @author Dmytro Parkhomenko
 *         Created on 03.12.16.
 */

public class DecimalDigitReverse {

    public static String reverse(int digit) {
        if(digit < 10) return String.valueOf(digit);
        return digit % 10 + reverse((digit - digit % 10) / 10);
    }

    public static int head3(int digit) {
        if(digit < 10) return 30 + digit;
        return head3(digit/10) * 10 + digit % 10;
    }

    public static void main(String[] args) {
        System.out.println(reverse(12345));
        System.out.println(head3(123));
    }
}
