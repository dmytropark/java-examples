package com.parkhomenko.core.polymorphism;

import java.io.FileNotFoundException;

/**
 * @author Dmytro Parkhomenko
 *         Created on 01.09.16.
 */

public class Animal {

    static void doSomething() {
    }

    void overridingMethod() throws FileNotFoundException {
        System.out.println("Animal: overridingMethod");
    }

    Animal overridingMethodOne() throws RuntimeException {
        System.out.println("Animal: overridingMethodOne");
        return new Animal();
    }

    protected void overridingMethodTwo() {
        System.out.println("Animal: overridingMethodTwo");
    }

    private void test() {
    }

    public final void test2() {
    }

    public static void test3() {
    }
}
