package com.lichao.two;

/**
 * @Author: lichao
 * @Date: 2020-03-26 21:23
 */
public class P_240 {

    public static boolean searchMatrix(int[][] matrix, int target) {

        if (matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        return searchMatrix(matrix, target, matrix.length - 1, 0);
    }




    public static boolean searchMatrix(int[][] matrix, int target, int x, int y) {
        if (y == matrix[0].length) {
            return false;
        }

        for (; x > 0; x--) {
            if (matrix[x][y] > target) {
                continue;
            } else if (matrix[x][y] == target) {
                return true;
            } else {
                break;
            }
        }
        if (x == 0) {
            for (int j = y; j < matrix[0].length; j++) {
                if (matrix[0][j] == target) {
                    return true;
                }
            }
            return false;
        }else {
            return searchMatrix(matrix, target, x, y + 1);
        }
    }




    public static void main(String[] args) {
//
//        int[][] input = {
//                {1, 4, 7, 11, 15},
//                {2, 5, 8, 12, 19},
//                {3, 6, 9, 16, 22},
//                {10, 13, 14, 17, 24},
//                {18, 21, 23, 26, 30}};

        int [][] input= {{1,4},{2,5}};

        System.out.println(searchMatrix(input, 4));

    }
}
