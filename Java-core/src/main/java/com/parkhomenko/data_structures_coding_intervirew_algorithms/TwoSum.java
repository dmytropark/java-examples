/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.parkhomenko.data_structures_coding_intervirew_algorithms;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author dmytro
 */
public class TwoSum {
    public static void main(String[] args) {
        TwoSum twoSum = new TwoSum();
        int[] nums = {2, 11, 15, 7};
        
        int[] res = twoSum.twoSum(nums, 9);
        System.out.println(Arrays.toString(res));
    }
    
    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2]; 
        Map<Integer, Integer> storage = new HashMap<>();
        
        for (int k = 0; k < nums.length; k++) {
            Integer a = storage.get(target - nums[k]);
            if(a != null) {
               res[0] = a;
               res[1] = k;
               break;
            } else {
                storage.put(nums[k], k);
            }
        }
        
        return res;
    }
}
