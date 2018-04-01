/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.parkhomenko;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author dmytro
 */
public class _4Sum {
    
    public static void main(String[] args) {
        _4Sum alghorithm = new _4Sum();
//        int[] arr = {1, 0, -1, 0, -2, 2};
        int[] arr = {-1, 0, 1, 2, -1, -4};
        
        List<List<Integer>> fourSum = alghorithm.fourSum(arr, -3);
        
        fourSum.forEach((list) -> {
            System.out.println(Arrays.toString(list.toArray()));
        });
    }
    
    public List<List<Integer>> fourSum(int[] nums, int target) {
        
        List<List<Integer>> res = new ArrayList<>();
        
        if(nums.length < 4) {
            return res;
        }
        
        Arrays.sort(nums);
        
        for (int i = 0; i < nums.length - 3; i++) {
            if(i > 0 && nums[i] == nums[i -1] ) {
                continue;
            }
            
            for (int j = i + 1; j < nums.length - 2; j++) {
                int a, b, c, d;
                a = nums[i];
                
                while(j > i + 1 && j < nums.length && nums[j] == nums[j - 1]) {
                    j++;
                }
                
                b = nums[j];
                int left = j + 1;
                int right = nums.length - 1;

                while(left < right) {
                    c = nums[left];
                    d = nums[right];

                    if(a + b + c + d == target ) {
                        res.add(Arrays.asList(a, b, c, d));

                        while(left < nums.length - 1 && c == nums[left + 1]) {
                            left++;
                        }

                        while(right > 0 && d == nums[right - 1]) {
                            right--;
                        }

                        left++;
                        right--;
                    } else {
                        if(a + b + c + d > target) {
                            right--;
                        } else {
                            left++;
                        }
                    }
                }    
            }
        }
        
        return res;
    }
}
