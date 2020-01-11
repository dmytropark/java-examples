package com.parkhomenko.core.wrapper_types;

/**
 * @author Dmytro Parkhomenko
 *         Created on 13.09.16.
 */

public class IntegerTester {
    public static void main(String[] args) {
        Byte b1 = Byte.valueOf("11");
        Byte b2 = Byte.valueOf("11");
        System.out.println("!!!!Is obj's equal: " + (b1 == b2));
    }
}
