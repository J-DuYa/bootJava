package com.example.demo.test;

import java.util.Arrays;

/**
 * 鸡尾酒算法
 * 双向
 * */
public class CocktailSort {

    public static void sort(int[] array) {
       int tmp = 0;
       for (int i = 0; i<array.length/2; i++) {
           boolean isSorted = true;
           for (int j = i; j<array.length-i-1; j++) {
               if (array[j]>array[j+1]) {
                   tmp = array[j];
                   array[j] = array[j+1];
                   array[j+1] = tmp;
                   isSorted = false;
               }
           }

           if (isSorted) {
               break;
           }

           isSorted = true;
           for (int j = array.length-i-1; j>i; j--) {
               if (array[j]<array[j-1]) {
                   tmp = array[j];
                   array[j] = array[j-1];
                   array[j-1] = tmp;
                   isSorted = false;
               }
           }

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
