package com.parkhomenko.core.regex;

import java.util.Scanner;
import java.util.regex.MatchResult;

/**
 * @author Dmytro Parkhomenko
 *         Created on 06.11.16.
 */

public class ScannerTester {

    public static void main(String[] args) {

        test_one();
    }

    public static void test_one() {
        String input = "1 fish 2 fish red fish blue 3 fish 4 fish black fish green";
        Scanner s = new Scanner(input);
        String inLine = s.findInLine("(\\d+) fish (\\d+) fish (\\w+) fish (\\w+)");
        String inLine2 = s.findInLine("(\\d+) fish (\\d+) fish (\\w+) fish (\\w+)");

        System.out.println("inLine = " + inLine);
        System.out.println("inLine2 = " + inLine2);

        MatchResult match = s.match();

        System.out.println(match.start());
        System.out.println(match.end());

        for(int i = 1; i <= match.groupCount(); i++) {
            System.out.println(match.group(i));
        }
    }

    public static void test_two() {
        Scanner s = new Scanner("One  ").useDelimiter("\\s");
        System.out.println(s.next());
        String next = s.next();
        System.out.println(next.isEmpty() ? "EMPTY" : "NO EMPTY");
    }
}
