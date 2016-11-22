package com.parkhomenko.algorithm_problems;

/**
 * @author Dmytro Parkhomenko
 *         Created on 20.09.16.
 */

public class TrueWaterAndWallTask {
    public static void main (String[] args) throws java.lang.Exception
    {
//        int[] wall = {2, 5, 1, 2, 3, 4, 7, 7, 6};
        int[] wall = {2, 1, 3, 1, 3, 2, 4, 0, 1, 0, 0, 2, 1, 0, 1, 2};
        System.out.println(calculateVolume(wall));
    }

    public static int calculateVolume(int[] land) {

        int leftMax = 0;
        int rightMax = 0;
        int left = 0;
        int right = land.length - 1;
        int volume = 0;

        while(left < right) {
            if(land[left] > leftMax) {
                leftMax = land[left];
            }
            if(land[right] > rightMax) {
                rightMax = land[right];
            }
            if(leftMax >= rightMax) {
                volume += rightMax - land[right];
                right--;
            } else {
                volume += leftMax - land[left];
                left++;
            }
        }
        return volume;
    }
}
