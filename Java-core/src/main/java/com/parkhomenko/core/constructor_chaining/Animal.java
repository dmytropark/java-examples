package com.parkhomenko.core.constructor_chaining;

/**
 * @author Dmytro Parkhomenko
 *         Created on 01.09.16.
 */

public class Animal {   
    private Head instanceAnimalVariable = new Head("Animal");
    private static Head staticAnimalVariable =  new Head("Animal static");

    {
        System.out.println("Animal instanse init block");
    }
    
    public Animal() {
        System.out.println("Animal constructed");
    }
    
    public void name(int p) {
        System.out.println("int param"); 
    }
}
