package com.parkhomenko.core.constructor_chaining;

/**
 * @author Dmytro Parkhomenko
 *         Created on 01.09.16.
 */

public class Animal {
    private static Head staticAnimalVariable =  new Head("Animal static");
    private Head instanceAnimalVariable = new Head("Animal");

    public Animal() {
        System.out.println("Animal constructed");
    }
}
