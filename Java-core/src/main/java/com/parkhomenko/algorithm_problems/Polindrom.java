package com.parkhomenko.algorithm_problems;

/**
 * @author Dmytro Parkhomenko
 *         Created on 16.10.16.
 */

public class Polindrom {

    public static int maxLength(String s) {
        int maxLength = 0;

        for (int i = 0; i < s.length(); i++) {
            int j = s.length() - 1;
            while(j > i) {
                if(isPolindrom(s, i, j)) {

                    int currLen = j - i + 1;

                    if(currLen > maxLength) {
                        maxLength = currLen;
                        break;
                    }
                }
            j--;
            }
        }

        return maxLength;
    }

    private static boolean isPolindrom(String s, int start, int end) {
        while(start < end) {
            if(s.charAt(start) != s.charAt(end)) {
                return false;
            }

            start++;
            end--;
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(isPolindrom("dima", 0, 3));
        System.out.println(isPolindrom("dia", 0, 2));
        System.out.println(isPolindrom("dimamid", 0, 6));
        System.out.println(isPolindrom("dimaamid", 0, 7));
        System.out.println(isPolindrom("dd", 0, 1));
        System.out.println(isPolindrom("dima", 0, 1));
        System.out.println("-----------------------------------");

        System.out.println(maxLength("ggdimamidgffffffffffg"));
        System.out.println(maxLength("aaafffbbabbccc"));
    }
}
