package com.parkhomenko.constructor_dependency_injection;

/**
 * @author Dmytro Parkhomenko
 *         Created on 31.07.17.
 */

public class Transmission {
    private final String sliding;

    public Transmission(String sliding) {
        this.sliding = sliding;
    }

    @Override
    public String toString() {
        return "Transmission{" +
                "sliding='" + sliding + '\'' +
                '}';
    }
}
