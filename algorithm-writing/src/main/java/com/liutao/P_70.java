package com.liutao;

/**
 * Author liutao
 * Date 2020/3/31 7:31 下午
 * Description:
 * Version: 1.0
 **/
public class P_70 {

    public static void main(String[] args) {

        System.out.println(new P_70().climbStairs(3));

    }

    public int climbStairs(int n) {

        int[] dp = new int[n];
        dp[0] = 1;
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        dp[1] = 2;
        for (int i = 2; i < n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];

        }

        return dp[n - 1];
    }

}
