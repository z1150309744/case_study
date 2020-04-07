package com.nishui.three;

/**
 * @Description 反转字符串中的单词 III
 * @Date 2020年04月06日 09时38分
 * @Created by yiwen
 */
public class P_00557 {

    public String reverseWords(String s) {
        StringBuffer stringBuffer = new StringBuffer();
        if (s == null || s.length() == 0) {
            return stringBuffer.toString();
        }

        String[] wordsArr = s.split(" ");

        for (int i = 0; i < wordsArr.length; i++) {
            stringBuffer.append(new StringBuffer(wordsArr[i]).reverse().toString() + " ");
        }
        return stringBuffer.toString().trim();
    }

//    public String reverse(String s) {
//        if (s == null) {
//            throw new IllegalArgumentException("params is error");
//        }
//
//        char tmp;
//        for (int l = 0, r = s.length() - 1; l < r; l++, r--) {
//            tmp = s.charAt(l);
//        }
//    }

}
