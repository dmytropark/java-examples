package com.parkhomenko.core.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Dmytro Parkhomenko
 *         Created on 27.10.16.
 */

public class RegexTester {
    public static void main(String[] args) {
        Pattern pattern = Pattern.compile("^[\\p{L}\\p{N}\\p{P}\\p{Z}]*$");
        Matcher matcher = pattern.matcher("Діма, - () #?!");
        System.out.println(matcher.matches());
    }
}
