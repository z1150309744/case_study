package com.nishui.two;

/**
 * @Description 最大子序和
 * @Date 2020年03月28日 12时57分
 * @Created by yiwen
 */
public class P_00064 {

    public static void main(String[] args) {

    }

    public int minPathSum(int[][] grid) {
        int rows;
        int cols;
        if (grid == null || (rows = grid.length) == 0 || (cols = grid[0].length) == 0) {
            return 0;
        }

        //初始化状态 dp[i][j] 表示从左上角到当前位置最小的路径
        int[][] dp = new int[rows][cols];
        dp[0][0] = grid[0][0];
        for (int i = 1; i < rows; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }

        for (int j = 1; j < cols; j++) {
            dp[0][j] = dp[0][j - 1] + grid[0][j];
        }

        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }
        return dp[rows - 1][cols - 1];
    }

}
