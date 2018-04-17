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
public class ContainerWithMostWater {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //int[] arr = {5, 2, 3, 7, 8, 1};
        int[] arr = {2, 0, 2, 0, 0, 0, 0, 1};
        ContainerWithMostWater containerWithMostWater = new ContainerWithMostWater();
        System.out.println("Result = " + containerWithMostWater.maxArea(arr));
    }

    public int maxArea(int[] height) {
        int maxArea = 0; 
        int leftBest = 0;
        int rightBest = 1;
       
        for(int rightIndex = 1; rightIndex < height.length; rightIndex++ ) {
            int optimalLeft = calcOptimalLeft(rightIndex, height);
            int currMaxArea = calcArea(optimalLeft, rightIndex, height);
            
            //System.out.println("currMaxArea = " + currMaxArea);
            
            if(currMaxArea > maxArea) {
                maxArea = currMaxArea;
                leftBest = optimalLeft;
                rightBest = rightIndex;
            }
        }
        
        System.out.println("leftBest = " + leftBest);
        System.out.println("rightBest = " + rightBest);
        
        return maxArea;
    }

    private int calcOptimalLeft(int rightIndex, int[] height) {
        int leftIndex = 0;
        int min = 0;
        
        for (int i = 0; i < rightIndex; i++) {
            int currMin = Math.min(height[i], height[rightIndex]);
            
            if(currMin >= min) {
                min = currMin;
                leftIndex = i;
            }
        }
        
        //System.out.println("opt leftIndex = " + leftIndex);
        
        return leftIndex;
    }

    private int calcArea(int leftIndex, int rightIndex, int[] height) {
        return (rightIndex - leftIndex) * Math.min(height[leftIndex], height[rightIndex]);
    }
    
}
