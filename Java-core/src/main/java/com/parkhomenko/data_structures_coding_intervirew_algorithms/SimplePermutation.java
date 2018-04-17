/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.parkhomenko.data_structures_coding_intervirew_algorithms;

import java.util.Arrays;

/**
 *
 * @author dmytro
 * 
 * https://uk.wikipedia.org/wiki/%D0%9F%D0%B5%D1%80%D0%B5%D1%81%D1%82%D0%B0%D0%BD%D0%BE%D0%B2%D0%BA%D0%B0
 * Дивися там розділ: Алгоритм отримання всіх перестановок
 */
public class SimplePermutation {

    public static void main(String[] args) {
        SimplePermutation sp = new SimplePermutation();
        sp.permutation(4);
    }

    public void permutation(int num) {
        int[] arr = new int[num];
        for (int i = 0; i < num; i++) {
            arr[i] = i;
        }

        System.out.println(Arrays.toString(arr));

        int i = num - 2;
        while (i >= 0) {
            if (arr[i] < arr[i + 1]) {

                int j = num - 1;
                while (j > i && arr[j] <= arr[i]) {
                    j--;
                }

                if (j > i) {
                    int tmp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = tmp;
                }

                for (int k = i + 1; k < (i + num + 1) / 2; k++) {
                    int tmp = arr[k];
                    arr[k] = arr[i + num - k];
                    arr[i + num - k] = tmp;
                }

                System.out.println(Arrays.toString(arr));

                i = num - 2;
            } else {
                i--;
            }
        }

        return;
    }
}
