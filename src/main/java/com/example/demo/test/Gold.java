package com.example.demo.test;

/**
 * 金矿问题
 * 动态规划算法
 * 1. 状态的定义
 * 2. 状态转移方程的定义
 * @param {w} 工人数量
 * @param {p} 金矿开采所需的工人的数量
 * @param {g} 金矿储量
 * */
public class Gold {
    public static int getBestGoldWining(int w, int[] p, int[] g) {
        int[] results = new int[w+1];
        for (int i=1; i<g.length; i++) {
            for (int j=w; j>=1; j--) {
                if (j>=p[i-1]) {
                    results[j] = Math.max(results[j], results[j-p[i-1]]+g[i-1]);
                }
            }
        }
        return results[w];
    }

    public static void main(String[] args) {
        int w = 10;
        int[] p = { 5, 5, 3, 4, 3 };
        int[] g = { 400, 500, 200, 300, 350 };
        int result = getBestGoldWining(w, p, g);
        System.out.println("result: " + result);
    }
}
