package com.parkhomenko.core.init_blocks;

import com.parkhomenko.core.constructor_chaining.Head;

/**
 * @author Dmytro Parkhomenko
 *         Created on 01.09.16.
 */

public class Animal {
    private Head instanceAnimalVariable = new Head("Animal instance var");
    private static Head staticElephantVariable = new Head("Animal static var");

    public final static int PORT = 24;

    static {
        System.out.println("Animal static init block works");
    }

    {
        System.out.println("Animal instance init block works");
    }

    public Animal() {
        System.out.println("Animal constructed");
    }
}
