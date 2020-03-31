package com.lichao.one;

import java.util.Stack;

/**
 * @Author: lichao
 * @Date: 2020-03-17 17:48
 */
class P_20 {
    public static boolean isValid(String s) {

        Stack<Character> stack = new Stack();

        for (int i = 0; i < s.length(); i++) {
            if (isPre(s.charAt(i))) {
                stack.push(s.charAt(i));
            } else if (isAft(s.charAt(i))) {
                if(stack.empty()){
                    return false;
                }
                char pre = stack.pop();
                if(! isMatch(pre, s.charAt(i))){
                    return false;
                }
            }
        }
        return stack.empty();
    }




    static boolean isPre(char c) {
        return c == '[' || c == '(' || c == '{';
    }




    static boolean isAft(char c) {
        return c == ']' || c == ')' || c == '}';
    }



    static boolean isMatch(char c, char d) {
        return c == '['? d == ']': ( c == '{' ? d == '}' : d == ')');
    }




    public static void main(String[] args) {
        String   input = "{[]";
        System.out.println(isValid(input));
    }
}