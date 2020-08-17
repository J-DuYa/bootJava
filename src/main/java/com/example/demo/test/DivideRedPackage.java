package com.example.demo.test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DivideRedPackage {

    public static List<Integer> dividePackage(Integer totalAmount, Integer totalPersonNum) {
        List<Integer> amountList = new ArrayList<>();
        Integer resTotalAmount = totalAmount;
        Integer resTotalPersonNum = totalPersonNum;

        Random random = new Random();

        for (Integer i = 0; i < totalPersonNum - 1; i++) {
            Integer amount = random.nextInt(resTotalAmount / resTotalPersonNum * 2 - 1) + 1;
            resTotalAmount -= amount;
            resTotalPersonNum--;
            amountList.add(amount);
        }

        amountList.add(resTotalAmount);
        return amountList;
    }

    public static void main(String[] args) {
        List<Integer> amountList = dividePackage(1000, 10);
        for (Integer amount: amountList) {
            System.out.println("抽到的金额：" + new BigDecimal(amount).divide(new BigDecimal(100)));
        }
    }
}
