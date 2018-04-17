/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.parkhomenko.data_structures_coding_intervirew_algorithms;

/**
 *
 * @author dmytro
 */
public class RemoveDuplicatesFromSortedArray {

    public static void main(String[] args) {
        RemoveDuplicatesFromSortedArray rdfsa = new RemoveDuplicatesFromSortedArray();
        int[] nums = {1, 1, 2, 2, 3};
        int len = rdfsa.removeDuplicates(nums);
        System.out.println(len);
    }

    public int removeDuplicates(int[] nums) {
        int low, high, len;

        if (nums == null) {
            return 0;
        }

        len = nums.length;

        if (len == 0) {
            return 0;
        }

        low = 0;

        for (high = 1; high < len; high++) {
            if (nums[high] != nums[low]) {
                nums[++low] = nums[high];
            }
        }

        return ++low;
    }
}
