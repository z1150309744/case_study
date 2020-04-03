package com.liutao.one;

/**
 * Author liutao
 * Date 2020/3/26 7:57 下午
 * Description:
 * Version: 1.0
 **/
public class P_221 {

    public static void main(String[] args) {
        //  [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]]
        char[][] matrix = new char[4][5];
        char[] a = {1, 0, 1, 0, 0};
        char[] b = {1, 0, 1, 1, 1};
        char[] c = {1, 1, 1, 1, 1};
        char[] d = {1, 0, 0, 1, 0};
        char[] f = {0, 0, 0, 0, 1};

        char[][] aaaaa = {{'1', '0', '1', '0', '0'}, {'1', '0', '1', '1', '1'}, {'1', '1', '1', '1', '1'}, {'1', '0', '0', '1', '0'}};
        matrix[0] = a;
        matrix[1] = b;
        matrix[2] = c;
        matrix[3] = d;
        // matrix[4] = f;
        System.out.println("chang " + aaaaa.length + " kuang : " + aaaaa[0].length);
        System.out.println(new P_221().maximalSquare(aaaaa));
    }

    /**
     * 暴力破解, n3
     *
     * @param matrix
     * @return
     */
    public int maximalSquare(char[][] matrix) {
        if (matrix.length == 0) {

            return 0;
        }
        int dp = 0;//最多可拓展深度, 每次失败后移动起始点,从
        if (matrix[0][0] == '1') {
            dp = 1;
        }
        //减植 如果 dp>=chang-i or dp>=kuang-j
        int chang = Math.max(matrix.length, matrix[0].length);
        int kuang = Math.min(matrix.length, matrix[0].length);

        boolean ischang = true;
        //长小于宽的情况
        if (matrix.length < matrix[0].length) {
            ischang = false;
        }
        for (int i = 0; i < chang; i++) {
            for (int j = 0; j < kuang; j++) {
                System.out.println("i is : " + i + " j is:" + j);
                if (dp >= chang - i || dp >= kuang - j) {
                    continue;
                }
//                if(matrix[0][0]==1){
//                    dp=1;
//                    continue;
//                }
                System.out.println("===");
                for (int f = dp; f < kuang - j; f++) {
                    System.out.println("f is : " + f);
                    //拉出求和面积
                    boolean hege = true;
                    if (!hege) {
                        break;
                    }
                    //判断子块是否是
                    for (int d = 0; d < f; d++) {
                        if (!hege) {
                            continue;
                        }
                        for (int g = 0; g < f; g++) {
                            if (!hege) {
                                continue;
                            }
                            System.out.println("d is : " + d + " g is:" + g);
                            // 长大于框
                            if (ischang) {
                                hege = matrix[i + g][j + d] == '1';
                            } else {
                                hege = matrix[j + g][i + d] == '1';
                            }
                        }
                    }
                    if (hege) {
                        dp = f;
                    }
                }
            }
        }
        // if(int i=0;i<kuang)


        return dp * dp;
    }

    public int maximalSquare1(char[][] matrix) {
        int rows = matrix.length, cols = rows > 0 ? matrix[0].length : 0;
        int[][] dp = new int[rows + 1][cols + 1];
        int maxsqlen = 0;
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= cols; j++) {
                if (matrix[i-1][j-1] == '1'){
                    dp[i][j] = Math.min(Math.min(dp[i][j - 1], dp[i - 1][j]), dp[i - 1][j - 1]) + 1;
                    maxsqlen = Math.max(maxsqlen, dp[i][j]);
                }
            }
        }
        return maxsqlen * maxsqlen;
    }


}
