package com.parkhomenko.core.init_blocks;

/**
 * @author Dmytro Parkhomenko
 *         Created on 01.09.16.
 */

public class Main {

    public static void main(String[] args) {
        try {
            Class.forName("com.parkhomenko.core.init_blocks.Animal");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        Animal animal = new Animal();
    }
}
