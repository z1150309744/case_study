package com.nishui.two;

/**
 * @Description 爬楼梯
 * @Date 2020/3/25 6:48 上午
 * @Created by yiwen
 */
public class P_00070 {

    public static void main(String[] args) {
        System.out.println(new P_00070().climbStairs(3));
    }

    public int climbStairs(int n) {
        if (n <= 1) {
            return n;
        }

        int[] dp = new int[n];

        dp[0] = 1;
        dp[1] = 2;

        for (int i = 2; i < n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n - 1];
    }

}
