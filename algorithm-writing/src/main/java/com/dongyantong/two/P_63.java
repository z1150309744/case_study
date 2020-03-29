package com.dongyantong.two;

/**
 * @Author: dongyantong
 * @Date: 2020/3/29
 */
public class P_63 {
    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4};
        System.out.println(maxProfit(prices));
    }

    public static int maxProfit(int[] prices) {
        int max = 0;
        int n = prices.length;
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                dp[i][j] = prices[j] - prices[i];
                max = Math.max(max, dp[i][j]);
            }
        }
        return max;
    }
}
