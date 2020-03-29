package com.parkhomenko.arrays_code_chalange;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class RemoveDuplicatesFromSortedArrayTest {

    @Test
    public void removeDuplicatesFromSortedArrayImplTest1() {
        int [] source = {1, 1, 2, 2, 3, 3};

        int length = removeDuplicates(source);

        Assert.assertEquals(3, length);
    }

    int removeDuplicates(int [] nums) {

        if(nums.length < 2) {
            return nums.length;
        }

        int length = 1;

        for (int i = 1; i < nums.length; i++) {

            if(nums[i] != nums[i - 1]) {
                length++;
            }
        }

        return length;
    }

    @Test
    public void removeDuplicatesFromSortedArrayImplTest2() {
        int [] source = {1, 1, 2, 2, 3, 3, 4, 5, 5, 6};

        int length = removeDuplicatesOrigin(source);

        Assert.assertEquals(6, length);

        //two fast way to print to stdout an array in Java:
        System.out.println(Arrays.toString(source));
        Arrays.stream(source).forEach(System.out::println);
    }

    int removeDuplicatesOrigin(int [] nums) {

        if(nums.length == 0) {
            return 0;
        }

        int j = 0;

        for (int i = 1; i < nums.length; i++) {

            if(nums[i] != nums[j]) {
                nums[++j] = nums[i];
            }
        }

        return ++j;
    }
}
