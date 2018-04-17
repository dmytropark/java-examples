/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.parkhomenko.effective_java_bloch_book;

import java.math.BigInteger;
import java.util.Random;
import org.junit.Test;

/**
 * Item1: Consider static factory methods instead of constructors
 * 
 * @author dmytro
 */

public class Item1 {
    @Test
    public void test_1() {
        Random rnd = new Random();
        BigInteger bigInteger = new BigInteger(4, 100, rnd);
        System.out.println("Res = " + bigInteger);
        BigInteger.probablePrime(4, rnd);
    }
}
