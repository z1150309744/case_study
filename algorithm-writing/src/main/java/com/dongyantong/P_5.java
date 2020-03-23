package com.dongyantong;

/**
 * @Author: dongyantong
 * @Date: 2020/3/23
 */
public class P_5 {
    public static void main(String[] args) {

    }

    public String longestPalindrome(String s) {
        if (s == null || s.length() < 1) {
            return "";
        }
        int left = 0;
        int right = 0;
        for (int i = 0; i < s.length(); i++) {
            // 奇数
            int len = aroundCenter(s, i, i);
            // 偶数
            int nextLen = aroundCenter(s, i, i + 1);
            int rLen = Math.max(len, nextLen);
            if (rLen > right - left) {
                left = i - (rLen - 1) / 2;
                right = i + rLen / 2;
            }

        }
        return s.substring(left, right + 1);

    }

    private int aroundCenter(String s, int left, int right) {
        int l = left;
        int r = right;
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            l--;
            r++;
        }
        return r - l - 1;
    }

    // 动态规划优化上面的中心扩散
    public String longestPalindrome2(String s) {
        if (s == null || s.length() < 2) {
            return s;
        }
        int strLen = s.length();
        int maxStart = 0;  //最长回文串的起点
        int maxEnd = 0;    //最长回文串的终点
        int maxLen = 1;  //最长回文串的长度

        boolean[][] dp = new boolean[strLen][strLen];

        for (int r = 1; r < strLen; r++) {
            for (int l = 0; l < r; l++) {
                if (s.charAt(l) == s.charAt(r) && (r - l <= 2 || dp[l + 1][r - 1])) {
                    dp[l][r] = true;
                    if (r - l + 1 > maxLen) {
                        maxLen = r - l + 1;
                        maxStart = l;
                        maxEnd = r;

                    }
                }

            }

        }
        return s.substring(maxStart, maxEnd + 1);

    }


}
