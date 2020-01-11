/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.parkhomenko.data_structures_coding_intervirew_algorithms;

import java.util.List;
import java.util.Stack;

/**
 *
 * @author dmytro
 */
public class ReverseWordsInString {

    public static void main(String[] args) {
        ReverseWordsInString rwis = new ReverseWordsInString();
        System.out.println(rwis.reverse("_ This is one line"));
        System.out.println(rwis.reverseV2("_ This is one line"));
    }

    public String reverse(String source) {
        if(source == null) {
            return "";
        }
        
        if(source.isEmpty()) {
            return "";
        }
        
        String res = "";
        String word = "";
        
        for (int i = 0; i < source.length(); i++) {
            if(!Character.isWhitespace(source.charAt(i))) {
                word = word + source.charAt(i);
            } else {
                res = source.charAt(i) + word + res;
                word = "";
            }
        }
        
        return word + res;
    }
    
    public String reverseV2(String source) {
        Stack stack = new Stack();
        StringBuilder sb = new StringBuilder();
        String tmp[] = source.split(" ");
        
        for (String item : tmp) {
            stack.push(item);
        }
        
        while(!stack.isEmpty()) {
            sb.append(stack.pop()).append(" ");
        }
        
        return sb.length() > 0 ? sb.substring(0, sb.length() - 1) : "";
    }
}
