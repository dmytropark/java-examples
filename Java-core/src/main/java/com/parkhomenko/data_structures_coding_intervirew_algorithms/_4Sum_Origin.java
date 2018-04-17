/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.parkhomenko.data_structures_coding_intervirew_algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author dmytro
 */
public class _4Sum_Origin {

    public static void main(String[] args) {
        _4Sum_Origin algorithm = new _4Sum_Origin();

        int[] arr = {-1, 0, 1, 2, -1, -4};

        List<List<Integer>> fourSum = algorithm.fourSum(arr, -3);

        fourSum.forEach((list) -> {
            System.out.println(Arrays.toString(list.toArray()));
        });
    }

    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();

        if (nums == null || nums.length < 4) {
            return res;
        }

        int len = nums.length;

        Arrays.sort(nums);

        int max = nums[len - 1];

        if (4 * nums[0] > target || 4 * max < target) {
            return res;
        }

        int i, z;

        for (i = 0; i < len; i++) {
            z = nums[i];

            if (i > 0 && z == nums[i - 1]) {
                continue;
            }

            if (z + 3 * max < target) {
                continue;
            }

            if (4 * z > target) {
                break;
            }

            if (4 * z == target) {
                if (i + 3 < len && nums[i + 3] == z) {
                    res.add(Arrays.asList(z, z, z, z));
                }

                break; // ???
            }

            threeSumForFourSum(nums, target - z, i + 1, len - 1, res, z);
        }

        return res;
    }

    public void threeSumForFourSum(
            int[] nums,
            int target,
            int low,
            int high,
            List<List<Integer>> fourSumList,
            int z1) {
        if (low + 1 >= high) {
            return;
        }

        int max = nums[high];

        if (3 * nums[low] > target || 3 * max < target) {
            return;
        }
        
        int i,z;
        
        for(i = low; i < high - 1; i++) {
            //TODO
        }
    }

}
