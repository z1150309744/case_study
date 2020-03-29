package com.lichao.one;

/**
 * @Author: lichao
 * @Date: 2020-03-20 10:36
 */
public class P_62 {


    static int[][] remember;




    public static int uniquePaths(int m, int n) {
        remember = new int[m + 1][n + 1];
        return uniquePathsInner(m, n);
    }




    public static int uniquePathsInner(int m, int n) {

        int ret = 0;
        if (m == 1 && n == 1) {
            return 1;
        }
        if (m > 1) {
            if (remember[m - 1][n] != 0) {
                ret = ret + remember[m - 1][n];
            } else {
                ret = ret + uniquePathsInner(m - 1, n);
            }

        }
        if (n > 1) {
            if (remember[m][n - 1] != 0) {
                ret = ret + remember[m][n - 1];

            } else {
                ret = ret + uniquePathsInner(m, n - 1);
            }
        }
        remember[m][n] = ret;
        return ret;

    }




    public static void main(String[] args) {
        int ret = uniquePaths(7, 3);
        System.console();
    }
}
