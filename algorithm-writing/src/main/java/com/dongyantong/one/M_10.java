package com.dongyantong.one;

/**
 * @Author: dongyantong
 * @Date: 2020/3/23
 * https://leetcode-cn.com/problems/qing-wa-tiao-tai-jie-wen-ti-lcof/
 */
public class M_10 {
    public static void main(String[] args) {

    }


    public int numWays(int n) {
        if (n <= 1) {
            return n;
        }
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[n] = dp[n - 1] + dp[n - 2];
        }
        return dp[n];
    }
}
