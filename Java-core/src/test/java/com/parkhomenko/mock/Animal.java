package com.parkhomenko.mock;

/**
 * @author Dmytro Parkhomenko
 *         Created on 09.09.16.
 */

public class Animal {
    private int age = 2;

    public void eat() {
        age = 4;
        System.out.println("Animal is eating...");
    }

    public int getAge() {
        return age;
    }
}
