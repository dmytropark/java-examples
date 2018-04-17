/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.parkhomenko.core.thread.deadlock;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author dmytro
 */
public class TreeNode {

    TreeNode parent = null;
    List children = new ArrayList();

    public synchronized void addChild(TreeNode child) {
        if (!this.children.contains(child)) {
            this.children.add(child);
            child.setParentOnly(this);
        }
    }

    public synchronized void addChildOnly(TreeNode child) {
        if (!this.children.contains(child)) {
            this.children.add(child);
        }
    }

    public synchronized void setParent(TreeNode parent) {
        this.parent = parent;
        parent.addChildOnly(this);
    }

    public synchronized void setParentOnly(TreeNode parent) {
        this.parent = parent;
    }
    
    public static void main(String[] args) throws InterruptedException, BrokenBarrierException {
        TreeNode parent = new TreeNode();
        TreeNode child = new TreeNode();
        
        final CyclicBarrier gate = new CyclicBarrier(3);
        
        new Thread(() -> {
            try {
                gate.await();
            } catch (InterruptedException ex) {
                Logger.getLogger(TreeNode.class.getName()).log(Level.SEVERE, null, ex);
            } catch (BrokenBarrierException ex) {
                Logger.getLogger(TreeNode.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            parent.addChild(child);
        }).start();
        new Thread(() -> {
            try {
                gate.await();
            } catch (InterruptedException ex) {
                Logger.getLogger(TreeNode.class.getName()).log(Level.SEVERE, null, ex);
            } catch (BrokenBarrierException ex) {
                Logger.getLogger(TreeNode.class.getName()).log(Level.SEVERE, null, ex);
            }
            child.setParent(parent);
        }).start();
        
        gate.await();
        System.out.println("all 2 threads started");
    }
}
