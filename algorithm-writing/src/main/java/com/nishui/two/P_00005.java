package com.nishui.two;

/**
 * @Description  最长回文子串
 * @Date 2020/3/23 8:10 下午
 * @Created by yiwen
 */
public class P_00005 {

    public static void main(String[] args) {
        String s = "abbc";
        System.out.println(new P_00005().longestPalindrome(s));
    }

    /**
     * 动态规划
     * @param s
     * @return
     */
    public String longestPalindrome(String s) {
        int len;
        if (s == null || (len = s.length()) < 2) {
            return s;
        }

        boolean[][] dp = new boolean[len][len];

        int max = 1;
        int begin = 0;
        int end = 0;

        for (int i = 1; i < len; i++) {
            for (int j = 0; j <= i; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    if (i == j || i - j < 2) {
                        dp[j][i] = true;
                    } else {
                        dp[j][i] = dp[j + 1][i - 1];
                    }
                } else {
                    dp[j][i] = false;
                }

                if (dp[j][i] && i - j + 1 > max) {
                    max = i - j + 1;
                    begin = j;
                    end = i;
                }
            }
        }
        return s.substring(begin, end + 1);
    }

}
