package com.parkhomenko.core.switch_test;

public class SwithTest {
    public static void main(String[] args) {
        Integer i = 10;
        System.out.println(Long.valueOf(i));

        String value = null;

        switch (value) {
            case "test":
                System.out.println("test1");
                break;
            default:
                System.out.println("test2");
                break;
        }

    }
}
