package com.nishui.str;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description 无重复字符的最长子串
 * @Date 2020年03月31日 09时34分
 * @Created by yiwen
 */
public class P_00003 {

    public static void main(String[] args) {
        System.out.println(new P_00003().lengthOfLongestSubstring("dvdf"));
    }

    public int lengthOfLongestSubstring(String s) {
        int len = 0;
        if (s == null || (len = s.length()) <= 1) {
            return len;
        }

        Map<Character, Integer> storage = new HashMap<>(s.length());
        int minIdx = 0;
        int maxSubStrLen = 0;
        for (int i = 0; i < len; i++) {
            if (storage.get(s.charAt(i)) != null) {
                minIdx = Math.max(minIdx, storage.get(s.charAt(i)));
            }

            maxSubStrLen = Math.max(maxSubStrLen, i - minIdx + 1);
            storage.put(s.charAt(i), i + 1);
        }
        return maxSubStrLen;
    }

}
