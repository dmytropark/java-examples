package com.parkhomenko.core.reflection;

import java.lang.reflect.Field;

public class Reflection {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        A a = new B();
        System.out.println(a.getClass());
        System.out.println(a.getClass().getField("value").get(a));

    }

    static class A {

    }

    static class B extends A {
        public String value = "bla";
    }
}
