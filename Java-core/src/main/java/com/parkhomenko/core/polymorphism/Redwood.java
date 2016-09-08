package com.parkhomenko.core.polymorphism;

/**
 * @author Dmytro Parkhomenko
 *         Created on 01.09.16.
 */

public class Redwood extends Tree {

    void go() {
        go2(new Tree(), new Redwood());
        go2((Redwood) new Tree(), new Redwood());
    }

    void go2(Tree t1, Redwood r1) {
        Redwood r2 = (Redwood)t1;
        Tree t2 = (Tree)r1;
    }

    public static void main(String[] args) {
        new Redwood().go();
    }
}
