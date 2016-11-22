package com.parkhomenko.declarative_transaction;


/**
 * @author Dmytro Parkhomenko
 *         Created on 26.09.16.
 */

public interface FooService {
    Foo getFoo(String fooName);

    Foo getFoo(String fooName, String barName);

    void insertFoo(Foo foo);

    void updateFoo(Foo foo);
}
