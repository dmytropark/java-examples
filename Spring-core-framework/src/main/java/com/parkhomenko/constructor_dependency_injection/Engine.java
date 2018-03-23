package com.parkhomenko.constructor_dependency_injection;

import org.springframework.beans.factory.BeanNameAware;

/**
 * @author Dmytro Parkhomenko
 *         Created on 31.07.17.
 */

public class Engine implements BeanNameAware {
    private final String type;
    private final int volum;

    public Engine(String type, int volum) {
        this.type = type;
        this.volum = volum;
    }

    @Override
    public String toString() {
        return "Engine{" +
                "type='" + type + '\'' +
                ", volum=" + volum +
                '}';
    }

    public void setBeanName(String name) {
        System.out.println("Engine bean id = " + name);
    }
}
