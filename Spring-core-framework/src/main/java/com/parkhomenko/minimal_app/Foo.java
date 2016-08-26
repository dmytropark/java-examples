package com.parkhomenko.minimal_app;

import org.springframework.stereotype.Service;

/**
 * @author Dmytro Parkhomenko
 *         Created on 26.08.16.
 */

@Service
public class Foo {

    public String run(final String input) {
        return input + " from Foo";
    }

}
