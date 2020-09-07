package com.example.demo.test;

import java.util.Arrays;

/**
 * 快速排序
 * */
public class PivotSort {

    public static void quickSort(int[] arr, int startIndex, int endIndex) {
        if (startIndex >= endIndex) {
            return;
        }

        // 获得基准元素的位置
        int privotIndex = partition(arr, startIndex, endIndex);
        quickSort(arr, startIndex, privotIndex - 1);
        quickSort(arr, privotIndex + 1, endIndex);
    }

    private static int partition(int[] arr, int startIndex, int endIndex) {
        int pivot = arr[startIndex];
        int left = startIndex;
        int right = endIndex;
        while (left != right) {
            while(left < right && arr[right] > pivot) {
                 right --;
            }

            while(left < right && arr[left] <= pivot) {
                left ++;
            }

            if (left < right) {
                int p = arr[left];
                arr[left] = arr[right];
                arr[right]=p;
            }
        }

        arr[startIndex] = arr[left];
        arr[left] = pivot;
        return left;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{4, 4, 6, 5, 3, 2, 8, 1};
        quickSort(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
}
