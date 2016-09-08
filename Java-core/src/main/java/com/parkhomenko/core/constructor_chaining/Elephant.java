package com.parkhomenko.core.constructor_chaining;

/**
 * @author Dmytro Parkhomenko
 *         Created on 01.09.16.
 */

public class Elephant extends Animal {
    private static Head staticElephantVariable =  new Head("Elephant static");
    private Head instanceElephantVariable = new Head("Elephant");

    public Elephant() {
        this("Dimka");
        System.out.println("Elephant constructed");
    }

    public Elephant(String name) {
        System.out.println("Elephant name is " + name);
    }

    public static void main(String[] args) {
        Elephant elephant = new Elephant();
    }
}
