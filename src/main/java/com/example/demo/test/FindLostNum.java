package com.example.demo.test;

/**
 * 寻找缺失的参数
 * */
public class FindLostNum {

    public static int[] findNumArray(int[] array) {
        int result[] = new int[2];
        int xorResult = 0;
        for (int i = 0; i < array.length; i++) {
            xorResult ^= array[i];
        }

        if (xorResult == 0) {
            return null;
        }

        int separator = 1;
        while (0 == (xorResult&separator)) {
            separator<<=1;
        }

        for (int i = 0; i < array.length; i++) {
            if (0 == (array[i]&separator)) {
                result[0]^=array[i];
            } else {
                result[1]^=array[i];
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] array = { 4, 1, 2, 2, 5, 1, 4, 3 };
        int[] result = findNumArray(array);
        System.out.println(result[0] + "," + result[1]);
    }
}
