package com.nishui.two;

/**
 * @Description 反转字符串
 * @Date 2020年04月05日 23时17分
 * @Created by yiwen
 */
public class P_00344 {

    public void reverseString(char[] s) {
        if (s == null || s.length <= 1) {}

        char tmp;
        for (int l = 0, r = s.length - 1; l < r; l++, r--) {
            tmp = s[l];
            s[l] = s[r];
            s[r] = tmp;
        }
    }

}
