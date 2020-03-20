package com.nishui;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @Description 有效的括号
 * @Date 2020/3/17 7:59 上午
 * @Created by yiwen
 */
public class P_20 {

    public static void main(String[] args) {
        System.out.println(P_20.isValid("]"));
    }

    public static boolean isValid(String s) {
        Map<String, String> leftMap = new HashMap<>();
        leftMap.put("(", ")");
        leftMap.put("{", "}");
        leftMap.put("[", "]");

        Map<String, String> rightMap = new HashMap<>();
        rightMap.put(")", "(");
        rightMap.put("}", "{");
        rightMap.put("]", "[");

        if (s == null || s.length() % 2 == 1) {
            return false;
        }
        if (s.equals("")) {
            return true;
        }

        Stack<String> stacks = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            String tmp = s.substring(i, i + 1);
            //说明是左边
            if (leftMap.get(tmp) != null) {
                stacks.push(tmp);
            } else {
                if (stacks.isEmpty()) {
                    return false;
                }
                String pop = stacks.pop();
                if (!pop.equals(rightMap.get(tmp))) {
                    return false;
                }
            }
        }
        if (!stacks.isEmpty()) {
            return false;
        }
        return true;
    }

}
