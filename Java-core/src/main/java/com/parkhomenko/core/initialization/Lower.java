package com.parkhomenko.core.initialization;

/**
 * @author Dmytro Parkhomenko
 *         Created on 28.11.16.
 */

public class Lower extends Upper {

    String lowerString = null;
//    String lowerString;

    public Lower() {
        super();
        System.out.println("Upper:  " + upperString);
        System.out.println("Lower:  " + lowerString);
    }

    public static void main(final String[] args) {
        new Lower();
    }
}

class Initializer {
    static void initialize(final Upper anUpper) {
        if (anUpper instanceof Lower) {
            Lower lower = (Lower) anUpper;
            lower.lowerString = "lowerInited";
        }
        anUpper.upperString = "upperInited";
    }
}

class Upper {
    String upperString;

    public Upper() {
        Initializer.initialize(this);
    }
}