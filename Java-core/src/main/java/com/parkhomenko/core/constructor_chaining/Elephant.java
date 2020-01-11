package com.parkhomenko.core.constructor_chaining;

import java.util.List;

/**
 * @author Dmytro Parkhomenko
 *         Created on 01.09.16.
 */

public class Elephant extends Animal {
    private static Head staticElephantVariable =  new Head("Elephant static");
    private Head instanceElephantVariable = new Head("Elephant");

    {
        System.out.println("Elephant instanse init block");
    }
    
    public Elephant() {
//        this("Dimka", false);
        this("Dimka");
        
        
        System.out.println("Elephant constructed");
    }

    public Elephant(String name, boolean flag) {
        System.out.println("Elephant name is " + name);
    }
    
    public Elephant(String name) {
        System.out.println("Elephant name is " + name);
    }
    
//    @Override
    public void name(Integer p) {
        System.out.println("long param"); 
    }

    public static void main(String[] args) {
        Elephant elephant = new Elephant();
        elephant.name(0);
    }
}
