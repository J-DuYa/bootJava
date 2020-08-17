package com.example.demo.test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RedPackage {

    public static List<Integer> divideRedPackage(Integer totalAmount, Integer totalPersonNum) {
         List<Integer> resultList = new ArrayList<Integer>();
         Integer resTotalAmount = totalAmount;
         Integer resTotalPersonNum = totalPersonNum;

         Random random = new Random();

         for (Integer i = 0; i < totalPersonNum-1; i++) {
            Integer amount = random.nextInt(resTotalAmount / resTotalPersonNum * 2 - 1) + 1;
            resTotalAmount -= amount;
            resTotalPersonNum--;
            resultList.add(amount);
         }

        resultList.add(resTotalAmount);

        return resultList;
    }

    public static void main(String[] args) {
        List<Integer> amountList = divideRedPackage(1000, 10);
        for (Integer amount: amountList) {
            System.out.println("抽奖金额: " + new BigDecimal(amount).divide(new BigDecimal(100)));
        }
    }
}
