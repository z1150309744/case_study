package com.dongyantong;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @Date 2020/3/17 8:47 上午
 * @Created by yiwen
 */
public class P_20 {

    public static void main(String[] args) {

        System.out.println(validParenthesis("()[]{}"));
    }

    private static Boolean validParenthesis(String s) {

        if (s == null || s.length() % 2 == 1) {
            return false;
        }
        if ("".equals(s)) {
            return true;
        }
        Map<String, String> left = new HashMap<>();
        left.put("(", ")");
        left.put("[", "]");
        left.put("{", "}");
        Map<String, String> right = new HashMap<>();
        right.put(")", "(");
        right.put("}", "{");
        right.put("]", "[");

        Stack<String> temp = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            String ss = s.substring(i, i + 1);
            if (left.containsKey(ss)) {
                temp.push(ss);
            } else {
                if (temp.isEmpty()) {
                    return false;
                }
                String pop = temp.pop();
                if (!pop.equals(right.get(ss))) {
                    return false;
                }
            }
        }
        if (!temp.isEmpty()) {
            return false;
        }
        return true;
    }

}
