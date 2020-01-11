/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.parkhomenko.core.thread;

import java.util.EventListener;

/**
 *
 * @author dmytro
 */
public class ThisEscape {
    private final int val = 1;
    
    public ThisEscape(EventSource source) {
        source.registerListener(
            new EventListener() {
                public void onEvent(Event e) {
                    doSomething(e);
                }
            });
    }
    
    private void doSomething(Event e) {
                    if(val == 1) {
                        System.out.println("1");
                    } else {
                        System.out.println("not 1");
                    };
            }
}