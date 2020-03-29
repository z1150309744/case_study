package com.dongyantong.one;

/**
 * @Author: dongyantong
 * @Date: 2020/3/28
 */
public class P_74 {
    public static void main(String[] args) {

    }

    public int minPathSum(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                // 圆点
                if (i == 0 && j == 0) {
                    continue;
                }

                // 在 X 轴上
                if (i == 0) {
                    grid[i][j] = grid[i][j - 1] + grid[i][j];
                }
                // 在 y 轴上
                else if (j == 0) {
                    grid[i][j] = grid[i - 1][j] + grid[i][j];
                }
                else {
                    grid[i][j] = Math.min(grid[i - 1][j], grid[i][j - 1]) + grid[i][j];
                }


            }
        }
        return grid[row - 1][col - 1];
    }

}
