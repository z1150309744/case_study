package com.lichao.one;

/**
 * @Author: lichao
 * @Date: 2020-01-15 22:13
 */
public class P_5 {
    public String longestPalindrome(String s) {

        if (s.isEmpty()) {
            return "";
        }
        char[] input = s.toCharArray();
        String res = "";
        int max = 1;

        // 0.1.2.3.4.5.6.7.8;
        //
        if (s.isEmpty()) {
            return "";
        }

        for (int i = 0; i < input.length; i++) {
            int temp = 1;
            int j;
            for (j = 1; i - j >= 0 && i + j < input.length; j++) {
                if (input[i - j] == input[i + j]) {
                    temp = temp + 2;
                } else {
                    break;
                }

            }
            if (temp > max) {
                max = temp;
                res = s.substring(i - j + 1, i + j - 1 + 1);
            }
            temp = 0;
            for (j = 0; i - j >= 0 && i + 1 + j < input.length; j++) {
                if (input[i - j] == input[i + j + 1]) {
                    temp += 2;
                } else {
                    break;
                }
            }
            if (temp > max) {
                max = temp;
                res = s.substring(i - j + 1, i + j + 1);
            }
        }
        if (max == 1)
            return input[0] + "";
        return res;
    }


}
