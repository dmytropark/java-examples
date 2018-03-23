package com.parkhomenko.constructor_dependency_injection.sub_package;

import com.parkhomenko.constructor_dependency_injection.Engine;
import com.parkhomenko.constructor_dependency_injection.Transmission;
import org.springframework.stereotype.Component;

/**
 * @author Dmytro Parkhomenko
 *         Created on 31.07.17.
 */

@Component
public class Car {

    private final Engine engine;
    private final Transmission transmission;

    public Car(Engine engine, Transmission transmission) {
        this.engine = engine;
        this.transmission = transmission;
    }

    @Override
    public String toString() {
        return "Car{" +
                "engine=" + engine +
                ", transmission=" + transmission +
                '}';
    }
}