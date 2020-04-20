package com.nishui.five;

/**
 * @Description 回文子串
 * @Date 2020年04月20日 09时19分
 * @Created by yiwen
 */
public class P_00647 {

    public static void main(String[] args) {
        System.out.println(new P_00647().countSubstrings("aaa"));
    }

    public int countSubstrings(String s) {
        int len;
        if (s == null || (len = s.length()) > 1000) {
            throw new IllegalArgumentException("param is error");
        }

        /** dp[i][j] 表示  i -> j 这个子串为回文串 **/
        boolean[][] dp = new boolean[s.length()][s.length()];

        //初始状态
//        dp[0][0] = 1;
        /**
         * 第一层正常遍历
         * 第二层遍历0 -> i 相当于将i 之前到i 的所有子串都列出来计算了
         */
        for (int i = 0; i < len; i++) {
            for (int j = 0; j <= i; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    if (i == j || i - j == 1) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i-1][j+1];
                    }
                } else {
                    dp[i][j] = false;
                }
            }
        }

        int count = 0;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j <= i; j++) {
                if (dp[i][j]) {
                    count++;
                }
            }
        }
        return count;
    }

}
