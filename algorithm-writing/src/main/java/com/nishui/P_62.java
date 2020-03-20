package com.nishui;

/**
 * @Description 不同路径
 * @Date 2020/3/20 7:58 上午
 * @Created by yiwen
 */
public class P_62 {


    public int uniquePaths2(int m, int n) {
        if (m < 0 || n < 0) {
            return 0;
        }
        if (m == 1 || n == 1) {
            return 1;
        }

        int[] dp = new int[m];
        dp[0] = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < m; j++) {
                dp[j] = dp[j - 1] + dp[j];
            }
        }
        return dp[m -1];
    }

    public int uniquePaths(int m, int n) {
        if (m < 0 || n < 0) {
            return 0;
        }

        if (m == 1 || n == 1) {
            return 1;
        }

        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }

        for (int i = 0; i < n; i++) {
            dp[0][i] = 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i][j - 1] + dp[i - 1][j];
            }
        }

        return dp[m - 1][n - 1];
    }

}
