/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.parkhomenko;

/**
 *
 * @author dmytro
 */
public class InterTest {
    
    public static Integer i = 10;
    
    protected void test() {
        
    }
    
    public static void main(String[] args) {
        InterTest i = null;
        
//        int i;
        
        System.out.println("i = " + i.i);
    }
    
    public class Inner extends InterTest {
    
        protected void test() {
        }
        
    }
}
