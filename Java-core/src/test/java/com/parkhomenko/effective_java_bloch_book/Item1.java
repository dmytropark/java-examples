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
    public void wrapper_cache_test() {
        Byte b1 = Byte.valueOf("11");
        Byte b2 = Byte.valueOf("11");
        System.out.println("Is obj's equal: " + (b1 == b2));
        
    }
}
