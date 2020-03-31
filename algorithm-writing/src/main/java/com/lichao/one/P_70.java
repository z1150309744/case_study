package com.lichao.one;

/**
 * describe:
 *
 * @author lichao
 * @date 2019/03/29
 */
public class P_70 {

    // 1
    // 2
    // 3




    public static int climbStairs(int n) {
        int first = 1;
        int second = 2;
        int i = 3;

        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        while (i <= n) {
            int temp = second;
            second = first + second;
            first = temp;
            i++;
        }
        return second;

    }




    public static void main(String[] args) {
        System.out.println(climbStairs(4));
    }
}
