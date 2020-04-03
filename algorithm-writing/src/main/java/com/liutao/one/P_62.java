package com.liutao.one;

/**
 * Author liutao
 * Date 2020/3/20 9:49 下午
 * Description:
 * Version: 1.0
 **/
public class P_62 {


    public static void main(String[] args) {
        System.out.println(new P_62().uniquePaths(2, 3));

    }

    /**
     * 计算会发现一个规律
     * 横竖列开始的路径都会会走一次
     *--------------------
     * 1 0 0
     * 0 0 0
     * --------------------
     * 1 1 0
     * 0 0 0
     * --------------------
     * 1 1 1
     * 0 0 0
     * --------------------
     * 1 1 1
     * 1 0 0
     * --------------------
     * 1 1 1
     * 1 2 0
     * --------------------
     * 1 1 1
     * 1 2 3
     *
     * 格子的走过的次数会等于 上边格子的走过次数+左边格子的走过次数,
     * 所以只需将每个格子走过的都计算出来, 终点的格子的值就会==能走的路径
     * @param m
     * @param n
     * @return
     */
    public int uniquePaths(int m, int n) {
        int[][] lu = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0)
                    lu[i][j] = 1;
                else {
                    lu[i][j] = lu[i - 1][j] + lu[i][j - 1];
                }
                print(lu,m,n);
            }

        }
        return lu[m - 1][n - 1];
    }

    private void print(int[][] lu,int m, int n) {
        System.out.println("--------------------");
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(lu[i][j]+ " ");
            }
            System.out.println("");

        }
    }


}
