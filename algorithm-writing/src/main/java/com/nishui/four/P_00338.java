package com.nishui.four;

/**
 * @Description 比特位计数
 * @Date 2020年04月13日 10时17分
 * @Created by yiwen
 */
public class P_00338 {

    public static void main(String[] args) {
        System.out.println(Integer.MAX_VALUE * 2L);
    }

    public int[] countBits(int num) {
        if (num < 0) {
            throw new IllegalArgumentException("num has to be positive");
        }

        int[] dp = new int[num + 1];
        dp[0] = 0;

        for (int i = 0; i <= num; i++) {
            if ((i & 1) == 1) {
                dp[i] = dp[i - 1] + 1;
            } else {
                dp[i] = dp[i >> 1];
            }
        }
        return dp;
    }

}
