package com.parkhomenko.core.init_blocks;

/**
 * @author Dmytro Parkhomenko
 *         Created on 04.09.16.
 */

public class Chick {
//    { System.out.println(name); } //WILL NOT COMPILE !!!
    private String name = "Fluffy";

    public static void main(String[] args) {
        Chick chick = new Chick();
        System.out.println(chick.name);
    }
}
