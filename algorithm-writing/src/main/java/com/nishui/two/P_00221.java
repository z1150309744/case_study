package com.nishui.two;

/**
 * @Author: 逆水
 * @Descripttion: 最大正方形
 * @Date: 2020年03月26日22时58分
 */
public class P_00221 {

    public static void main(String[] args) {
        char[][] matrix = new char[][]{
                {'1','0','1','0','0'},
                {'1','0','1','1','1'},
                {'1','1','1','1','1'},
                {'1','0','1','1','1'}
        };
        System.out.println(new P_00221().maximalSquare(matrix));
    }

    private static char ONE_CHAR = '1';

    /**
     * dp
     * @param matrix
     * @return
     */
    public int maximalSquare(char[][] matrix) {
        int rows;
        int cols;
        if (matrix == null
                || (rows = matrix.length) == 0
                || (cols = matrix[0].length) == 0) {
            return 0;
        }

        //存储状态的数组
        int[][] dp = new int[rows][cols];

        int maxSq = 0;

        //遍历
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                //只处理为1的 字符会转成int 进行比较
                if (matrix[i][j] == ONE_CHAR) {
                    if (i == 0 || j == 0) {
                        dp[i][j] = 1;
                    } else {
                        dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
                    }

                    if (dp[i][j] > maxSq) {
                        maxSq = dp[i][j];
                    }
                } else {
                    dp[i][j] = 0;
                }
            }
        }
        return maxSq * maxSq;
    }

}
