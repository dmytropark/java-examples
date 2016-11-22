package com.parkhomenko.algorithm_problems;

/**
 * @author Dmytro Parkhomenko
 * Created on 15.09.16.
 */

import java.util.ArrayList;
import java.util.List;

/**
 * 3. Задача, которую давали на собеседованиях в Apple.
 * Представьте, что вы получили работу кассира в магазине.
 * Ваш босс случайно выяснил, что вы обладаете навыками программиста, и захотел,
 * чтобы вы помогли ему написать программу. В качестве входных данных вы получаете определённую сумму денег
 * и все доступные номиналы монет, а написать нужно функцию,
 * которая на выходе выдаст количество всех возможных способов
 * получить указанную сумму денег при помощи различных доступных номиналов монет.
 */

public class AppleMonetaryTask {

    static int evaluateAllVariants(int summa, int k, int[] nominals, List<Integer> list) {
        int result = 0;

        for (int i = k; i < nominals.length; i++) {

            List<Integer> newList = new ArrayList<>(list);

            newList.add(nominals[i]);

            int add = isValid(summa, newList) ? 1 : 0;

            result = result + add + evaluateAllVariants(summa, i + 1, nominals, newList);
        }

        return result;
    }

//    static int evaluateAllVariantsV2(int summa, int k, int[] nominals, List<Integer> list) {
//        if (k >= nominals.length) {
//            return 0;
//        }
//        List<Integer> newList = new ArrayList<>(list);
//        newList.add(nominals[k]);
//        int add = isValid(summa, newList) ? 1 : 0;
//        return add + evaluateAllVariantsV2(summa, k + 1, nominals, newList);
//    }

    static boolean isValid(int summa, List<Integer> nominals) {
       return nominals.stream().reduce(0, Integer::sum) == summa;
    }

    public static void main(String[] args) {
        System.out.println("In progress ...");
        System.out.println(evaluateAllVariants(6, 0, new int[]{1, 2, 3, 5}, new ArrayList<>()));
//        System.out.println(evaluateAllVariantsV2(1, 0, new int[]{1, 1}, new ArrayList<>()));
        System.out.println("Finished");
    }

}
