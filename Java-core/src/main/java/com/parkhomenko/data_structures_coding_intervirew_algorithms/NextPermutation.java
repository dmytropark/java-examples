/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.parkhomenko.data_structures_coding_intervirew_algorithms;

import java.util.Arrays;
import java.util.Collections;
import static java.util.Collections.list;
import java.util.List;

/**
 *
 * @author dmytro
 */
public class NextPermutation {

    public static void main(String[] args) {
        NextPermutation np = new NextPermutation();
        int[] nums = {3, 2, 1};
        np.permutation(nums);
        System.out.println(Arrays.toString(nums));
    }

    public void permutation(int[] nums) {
        if (nums == null) {
            return;
        }

        int len = nums.length;

        if (len < 2) {
            return;
        }

        boolean isSuccess = false;
        int i = len - 2;
        while (i >= 0) {
            if (nums[i] < nums[i + 1]) {

                int j = len - 1;
                while (j > i && nums[j] <= nums[i]) {
                    j--;
                }

                if (j > i) {
                    int tmp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = tmp;
                }

                for (int k = i + 1; k < (i + len + 1) / 2; k++) {
                    int tmp = nums[k];
                    nums[k] = nums[i + len - k];
                    nums[i + len - k] = tmp;
                }

                isSuccess = true;
                break;
            } else {
                i--;
            }
        }

        if (!isSuccess) {
            for (int j = 0; j < len / 2; j++) {
                int tmp = nums[j];
                nums[j] = nums[len - j - 1];
                nums[len - j - 1] = tmp;
            }
        }
    }
}
