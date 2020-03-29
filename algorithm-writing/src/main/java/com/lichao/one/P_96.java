package com.lichao.one;

/**
 * @Author: lichao
 * @Date: 2020-03-24 22:36
 */
public class P_96 {
    //1 2 3 4 5 6 7
    public static int numTrees(int n) {
        int[] db = new int[n + 1];
        db[0] = 1;
        db[1] = 1;
        int i = 2;
        while (i <= n) {
            int sum = 0;
            for (int j = 0; j < i; j++) {
                sum += (db[j] * db[i - j - 1]);
            }
            db[i] = sum;
            i++;
        }
        return db[n];
    }




    public static void main(String[] args) {
        System.out.println(numTrees(3));
    }
}
