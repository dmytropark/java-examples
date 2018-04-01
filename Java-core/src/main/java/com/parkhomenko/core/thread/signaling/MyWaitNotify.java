/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.parkhomenko.core.thread.signaling;

/**
 *
 * @author dmytro
 */
public class MyWaitNotify {

    final MonitorObject myMonitorObject = new MonitorObject();
    boolean wasSignalled = false;

    public void doWait() {
        String threadName = Thread.currentThread().getName();

        System.out.println(threadName + ": 1");

        synchronized (myMonitorObject) {
//            if (!wasSignalled) {
            while (!wasSignalled) { // spin lock
                try {
                    System.out.println(threadName + ": 2");
                    myMonitorObject.wait();
                    System.out.println(threadName + ": 3");
                } catch (InterruptedException e) {
                    System.out.println(threadName + ": 4");
                }
            }
            //clear signal and continue running.
            System.out.println(threadName + ": 8");
            wasSignalled = false;
        }
    }

    public void doNotify() {
        String threadName = Thread.currentThread().getName();

        System.out.println(threadName + ": 5");
        synchronized (myMonitorObject) {
            System.out.println(threadName + ": 6");
            wasSignalled = true;
            myMonitorObject.notifyAll();
            System.out.println(threadName + ": 7");
        }
    }

    public static void main(String[] args) {
        MyWaitNotify myWaitNotify = new MyWaitNotify();

        new Thread(new Runnable() {
            @Override
            public void run() {
                myWaitNotify.doWait();
            }
        }, "thead #1").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                myWaitNotify.doWait();
            }
        }, "thead #2").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                myWaitNotify.doNotify();
            }
        }, "thead #3").start();    

    }
}
