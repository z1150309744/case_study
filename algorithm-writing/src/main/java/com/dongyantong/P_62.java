package com.dongyantong;

import java.util.Arrays;

/**
 * @Author: dongyantong
 * @Date: 2020/3/20
 */
public class P_62 {
    public static void main(String[] args) {

        System.out.println(uniquePaths(7, 3));
        System.out.println(uniquePaths2(7, 3));
    }

    // 空间压缩
    public static int uniquePaths(int m, int n) {
        int[] cur = new int[n];
        Arrays.fill(cur, 1);
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                cur[j] += cur[j - 1];
            }
        }
        return cur[n - 1];
    }

    // 动态规划
    public static int uniquePaths2(int m, int n) {
        if (m <= 0 || n <= 0) {
            return 0;
        }

        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int j = 0; j < n; j++) {
            dp[0][j] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }
}
