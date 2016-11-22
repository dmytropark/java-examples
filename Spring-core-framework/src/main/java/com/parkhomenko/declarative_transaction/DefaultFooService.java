package com.parkhomenko.declarative_transaction;

import org.springframework.transaction.annotation.Transactional;

/**
 * @author Dmytro Parkhomenko
 *         Created on 26.09.16.
 */

public class DefaultFooService implements FooService {

    public Foo getFoo(String fooName) {
        throw new UnsupportedOperationException();
    }

    public Foo getFoo(String fooName, String barName) {
        throw new UnsupportedOperationException();
    }

    public void insertFoo(Foo foo) {
        throw new UnsupportedOperationException();
    }

    @Transactional
    public void updateFoo(Foo foo) {
        System.out.println("updateFoo worked !!!!");
    }

}
