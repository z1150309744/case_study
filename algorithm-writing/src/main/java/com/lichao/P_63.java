package com.lichao;

/**
 * describe: 动态规划思想。每一格的路径数=该格上面格子的路径数+该格左边格子的路径数。（第一排和第一列的单独考虑）
 *
 * @author lichao
 * @date 2019/03/17
 */
class P_63 {
    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {

        if (null == obstacleGrid || 0 == obstacleGrid.length || 0 == obstacleGrid[0].length) {
            return 0;
        }

        int n = obstacleGrid.length;
        int m = obstacleGrid[0].length;
        int[][] db = new int[n][m];

        for (int i = 0; i < n; i++) {
            if (obstacleGrid[i][0] == 0) {
                db[i][0] = 1;
            } else {
                break;
            }
        }
        for (int i = 0; i < m; i++) {
            if (obstacleGrid[0][i] == 0) {
                db[0][i] = 1;
            } else {
                break;
            }
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (obstacleGrid[i][j] == 0) {
                    db[i][j] = db[i - 1][j] + db[i][j - 1];
                } else {
                    db[i][j] = 0;
                }
            }
        }
        return db[n - 1][m - 1];
    }

    public static void main(String [] args){
        int [][] input = {{0,0,0}, {0,1,0},{0,0,0}};
        System.out.println(uniquePathsWithObstacles(input));
    }
}