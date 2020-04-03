package com.liutao.one;

/**
 * Author liutao
 * Date 2020/3/28 9:56 下午
 * Description:
 * Version: 1.0
 **/
public class P_64 {

    public static void main(String[] args) {
        int[][] matrix = new int[5][5];
        int[] a = {1, 0, 1, 0, 0};
        int[] b = {1, 0, 1, 1, 1};
        int[] c = {1, 1, 1, 1, 1};
        int[] d = {1, 0, 0, 1, 0};
        int[] f = {0, 0, 0, 0, 1};
        matrix[0]=a;
        matrix[1]=b;
        matrix[2]=c;
        matrix[3]=d;
        matrix[4]=f;

        System.out.println("chang " + matrix.length + " kuang : " + matrix[0].length);
        System.out.println(new P_64().minPathSum(matrix));
    }


    public int minPathSum(int[][] grid) {
        int chang = grid.length;   // 长
        int kuang = grid[0].length; // 宽
        for (int i = 0; i < chang; i++) {
            for (int j = 0; j < kuang; j++) {
                if (i == 0 && j == 0) {
                    grid[0][0]=grid[i][j];
                    continue;
                }
                //处理第一行数据
                if (i == 0) {
                    grid[0][j] = grid[i][j] + grid[i][j - 1];
                    continue;
                }
                //处理第二行数据
                if (j == 0) {
                    grid[i][0] = grid[i][j] + grid[i - 1][j];
                    continue;
                }
                //更新每格内最小的值
                grid[i][j] = Math.min(grid[i][j] + grid[i - 1][j], grid[i][j] + grid[i][j - 1]);
            }
        }
        //返回最后一列
        return grid[grid.length - 1][grid[0].length - 1];
    }
}
