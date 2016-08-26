package com.parkhomenko.util.random;

import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * Created by dmitro on 3/14/16.
 */
public class CustomGenerator<T> {

    public T generateUniqueCode(Supplier<T> supplier, Predicate<T> predicate) {
        T code = supplier.get();

        while(predicate.test(code)) {
            code = supplier.get();
        }

        return code;
    }
}
