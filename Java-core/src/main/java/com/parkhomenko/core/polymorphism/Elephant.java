package com.parkhomenko.core.polymorphism;

import java.io.FileNotFoundException;

/**
 * @author Dmytro Parkhomenko
 *         Created on 01.09.16.
 */

public class Elephant extends Animal {

    static void doSomething() {
    }

    void overridingMethod() {
        System.out.println("Elephant: overridingMethod");
    }

    Elephant overridingMethodOne() {
        System.out.println("Elephant: overridingMethodOne");
        return new Elephant();
    }

    public void overridingMethodTwo() throws RuntimeException {
        System.out.println("Animal: overridingMethodTwo");
    }

    public void test() {
    }

//    public void test2() {
//    }

    public static void test3() {
    }

    public static void main(String[] args) {
        Animal animal = new Elephant();

        try {
            animal.overridingMethod();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        animal.overridingMethodTwo();
    }

}
