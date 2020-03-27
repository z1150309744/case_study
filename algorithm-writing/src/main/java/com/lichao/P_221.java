package com.lichao;

/**
 * @Author: lichao
 * @Date: 2020-03-26 21:23
 */
public class P_221 {

    public static int maximalSquare(char[][] matrix) {


        /**
         *
         * 1 0 1 0 0
         * 1 0 1 1 1
         * 1 1 1 1 1
         * 1 0 0 1 0
         *
         *
         * 1 0 1 0 0
         * 1 0 1 1 1
         * 1 1 1 2 2
         * 1 0 0 1 0
         *
         * */

        /**
         *
         * 1 0 1 0 0
         * 1 0 1 1 1
         * 1 1 1 1 1
         * 1 0 1 1 1
         *
         *
         * 1 0 1 0 0
         * 1 0 1 1 1
         * 1 1 1 2 2
         * 1 0 1 2 3
         *
         * */


        int max = 0;
        if (matrix.length == 0) {
            return 0;
        }

        int[][] db = new int[matrix.length][matrix[0].length];

        // 复制第一行
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][0] == '1') {
                db[i][0] = 1;
                max = 1;
            }
        }

        // 复制第一列
        for (int i = 0; i < matrix[0].length; i++) {
            if (matrix[0][i] == '1') {
                db[0][i] = 1;
                max = 1;
            }
        }

        // 推导出其他
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[i].length; j++) {
                if (matrix[i][j] == '0') {
                    db[i][j] = 0;
                }else{
                    db[i][j] = 1 + Math.min (db[i-1][j-1], Math.min(db[i][j-1], db[i-1][j]));
                    if(db[i][j] > max){
                        max = db[i][j];
                    }
                }
            }
        }
        return max * max ;
    }




    public static void main(String[] args) {


        char[][] input = {
                {'1', '0', '1', '0', '0'},
                {'1', '0', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'1', '0', '0', '1', '0'}
        };

        System.out.println(maximalSquare(input));

    }
}
