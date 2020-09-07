package com.example.demo.test;

import java.util.Arrays;

/**
 * 冒泡排序
 * */
public class BubbleSort {
    public static void sort(int[] array) {
        // 记录每轮排序后的最后一个值
        int lastExchangeIndex = 0;
        int sortBorder = array.length-1;
        for (int i = 0; i < array.length-1; i++) {
            boolean isSorted = true;
            for (int j = 0; j < sortBorder; j++) {
                int tmp = 0;
                if (array[j] > array[j+1]) {
                    tmp = array[j];
                    array[j] = array[j + 1];
                    array[j+1] = tmp;
                    isSorted = false;
                    lastExchangeIndex = j;
                }
            }
            sortBorder = lastExchangeIndex;
            if (isSorted) {
                break;
            }
        }
    }

    public static void main(String[] args) {
        int[] array = new int[]{1, 2, 5, 7, 3 ,9};
        sort(array);
        System.out.println(Arrays.toString(array));
    }
}
