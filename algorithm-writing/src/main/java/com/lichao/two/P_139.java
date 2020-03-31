package com.lichao.two;

/**
 * @Author: lichao
 * @Date: 2020-03-30 21:38
 */

import java.util.ArrayList;
import java.util.List;

class P_139 {
    public static boolean wordBreak(String s, List<String> wordDict) {
        boolean[] db = new boolean[s.length()];
        for (int i = 0; i < s.length(); i++) {
            for (String word : wordDict) {
                if ((((i + 1) > word.length() && db[i - word.length()] == true)
                        || ((i + 1) == word.length())
                )) {
                    boolean success = true;
                    for (int k = word.length(); k > 0; k--) {
                        if(word.charAt(k-1) != s.charAt(i -(word.length() - k))){
                            success = false;
                            break;
                        }
                    }
                    if(success) {
                        db[i] = true;
                        break;
                    }
                }
            }
        }
        return db[s.length() -1];

    }




    public static void main(String[] args) {

        String s = "a";
        List<String> wordDict = new ArrayList<>();
//        wordDict.add("cats");
//        wordDict.add("dog");
//        wordDict.add("sand");
//        wordDict.add("and");
//        wordDict.add("cat");
        System.out.println(wordBreak(s, wordDict));
    }
}