/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.parkhomenko.data_structures_coding_intervirew_algorithms;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 *
 * @author dmytro
 */
public class _3Sum {
    public static void main(String[] args) {
        _3Sum s = new _3Sum();
        int[] nums = {-1, 0, 1, 2, -1, -4}; 
        List<List<Integer>> threeSum = s.threeSum(nums);
        
        threeSum.forEach((list) -> {
            System.out.println(Arrays.toString(list.toArray()));
        });
    }
    
    
    public List<List<Integer>> threeSum(int[] nums) {
        Set<String> result = new HashSet<>();
        
        for (int i = 0; i < nums.length; i++) {
           
            for (int j = i + 1; j < nums.length; j++) {
                
                for (int k = j + 1; k < nums.length; k++) {
                   
                    if((nums[i] + nums[j] + nums[k]) == 0) {
                        List<Integer> tripletData = Arrays.asList(nums[i], nums[j], nums[k]);
                        Collections.sort(tripletData);
                        result.add(tripletData.get(0) + "," + tripletData.get(1) + "," + tripletData.get(2));
                    }
            
                }
            
            }
           
        }
        
        return result.stream().map(item -> {
            return Arrays.asList(item.split(","))
                    .stream().map(Integer::valueOf).collect(Collectors.toList());
        }).collect(Collectors.toList());
    }
      
}
