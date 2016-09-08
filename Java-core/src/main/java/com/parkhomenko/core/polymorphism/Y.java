package com.parkhomenko.core.polymorphism;

/**
 * @author Dmytro Parkhomenko
 *         Created on 01.09.16.
 */

public class Y extends X {
    void do2() {
        System.out.println("Y: do2");
    }

    String test() {
        System.out.println("Y test");
        return null;
    }

    public static void main(String[] args) {
        X x = new Y();
        Y y = new Y();
        X x1 = new X();

        //downcast in action
        ((Y) x).do2();

//        x.test();
//        ((X)y).test();
//        y = (Y) x;
//        y.do2();
//        Y y1 = (Y) x1;
//        y1.do2();
//        X x1 = new X();
//        X x2 = new Y();
//        Y y1 = new Y();
//        Y y2 = (Y)x1;
//        ((Y)x2).do2();
//        x1 = y1;
//        ((X)y1).do1();
//        ((Y)x1).do2();
    }
}
