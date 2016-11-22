package com.parkhomenko.algorithm_problems;

/**
 * @author Dmytro Parkhomenko
 *         Created on 20.09.16.
 */

import java.util.Arrays;

/**
 * 2. Представьте себе картинку, на которой изображены стены различной высоты в некотором плоском мире.
 * Картинка представлена массивом целых чисел, где индекс — это точка на оси X,
 * а значение каждого индекса — это высота стены (значение по оси Y).
 * Теперь представьте, что начался дождь, который не прекращается и поливает стены сверху равномерным потоком.
 * Сколько воды соберется в «лужах» между стенами?
 */

public class WaterAndWallTask {

    public static void main(String[] args) {
        int[] wall = {2, 1, 3, 1, 3, 2, 4, 0, 1, 0, 0, 2, 1, 0, 1, 2}; //res = 15
//        int[] wall = {2, 5, 1, 2, 3, 4, 7, 7, 6};

        System.out.println(WaterAndWallTask.calculateWater(wall));
    }

    public static int calculateWater(int[] wall) {
        final int WALL_HEIGHT = Arrays.stream(wall).reduce(0, Integer::max);
        int waterCounter = 0;
        Water water = new Water();

        for(int currWaterLevel = 1; currWaterLevel <= WALL_HEIGHT; currWaterLevel++) {
            water.resetSearch();
            for (int currWallHeight : wall) {
                waterCounter += water.search(new Point(currWallHeight, currWaterLevel));
            }
        }

        return waterCounter;
    }

    static class Water {
        int amount;

        Water() {
            resetSearch();
        }

         int search(Point point) {
             if (checkStart(point)) { return 0; }
             if (checkMiddle(point)) { return 0; }
             return checkEnd(point);
        }

        private int checkEnd(Point point) {
            if(amount > 0 && point.wallHeight >= point.waterLevel) {
               int result = amount;
               amount = 0;
               return result;
            }

            return 0;
        }

        private boolean checkMiddle(Point point) {
            if(amount > 0 && point.wallHeight < point.waterLevel) {
                amount++;
                return true;
            }

            return false;
        }

        private boolean checkStart(Point point) {
            boolean condition = amount == -1 && point.wallHeight >= point.waterLevel;
            if(condition) {
                amount = 0;
            }

            return condition;
        }

        void resetSearch() {
            amount = -1;
        }
    }

    static class Point {
        int wallHeight;
        int waterLevel;

        Point(int wallHeight, int waterLevel) {
            this.wallHeight = wallHeight;
            this.waterLevel = waterLevel;
         }
     }
}
