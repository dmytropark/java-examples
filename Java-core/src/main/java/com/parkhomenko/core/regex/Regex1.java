package com.parkhomenko.core.regex;

/**
 * Created by dmytro on 1/13/17.
 */
public class Regex1 {

    //        Pattern pattern = Pattern.compile(F_20_VALUE);
//        Matcher matcher = pattern.matcher("12772");
//        boolean x = matcher.find();
//        int end = matcher.end();
//        System.out.println(x);
//        System.out.println(end);


    private static final String F50_VALUE_TYPE_AND_ACCOUNT = "^/([abc]{3})/(\\d{3})$";

    public static void main(String[] args) {
        String EXAMPLE_TEST = "/abc/321";
        System.out.println(EXAMPLE_TEST.replaceAll(F50_VALUE_TYPE_AND_ACCOUNT, "$1"));
        System.out.println(EXAMPLE_TEST.replaceAll(F50_VALUE_TYPE_AND_ACCOUNT, "$2"));
    }
}
