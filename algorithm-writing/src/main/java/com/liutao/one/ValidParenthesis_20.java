package com.liutao.one;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @Description 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 * <p>
 * 有效字符串需满足：
 * <p>
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ValidParenthesis_20 {


    public static void main(String[] args) {


        ValidParenthesis_20 validParenthesis_20 = new ValidParenthesis_20();
        System.out.println(validParenthesis_20.isValid("{()}"));
    }

    /**
     * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
     * <p>
     * 有效字符串需满足：
     * <p>
     * 左括号必须用相同类型的右括号闭合。
     * 左括号确的顺必须以正序闭合。 有顺序!!!!!!
     * 注意空字符串可被认为是有效字符串。 排除空字符串
     * <p>
     * 示例 1:
     * <p>
     * 输入: "()"
     * 输出: true
     * 示例 2:
     * <p>
     * 输入: "()[]{}"
     * 输出: true
     * 示例 3:
     * <p>
     * 输入: "(]"
     * 输出: false
     * 示例 4:
     * <p>
     * 输入: "([)]"
     * 输出: false
     * 示例 5:
     * <p>
     * 输入: "{[]}"
     * 输出: true
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/valid-parentheses
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param s
     * @return
     */
    public boolean isValid(String s) {
        if (s == null || s.length() % 2 == 1) {
            return false;
        }
        if ("".equals(s)) {
            return true;
        }

        Map<Character, Character> leftMap = new HashMap<>();
        leftMap.put('(', ')');
        leftMap.put('[', ']');
        leftMap.put('{', '}');
        Map<Character, Character> rightMap = new HashMap<>();
        rightMap.put(')', '(');
        rightMap.put('}', '{');
        rightMap.put(']', '[');
        Stack<Character> stacks = new Stack<>();
        for (char word : s.toCharArray()) {
            if (leftMap.get(word) != null) {
                stacks.push(leftMap.get(word));
            } else {
                if (stacks.isEmpty()) { //顺序不对直接返回false
                    return false;
                }
                char rightData = stacks.pop(); // pop出来的是
                if (rightData != word) {
                    return false;
                }
            }

        }
        return stacks.isEmpty();

    }


    public boolean isValid2(String s) {
        if (s == null || s.length() % 2 == 1) {
            return false;
        }
        if ("".equals(s)) {
            return true;
        }
        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[');
        Stack<Character> stacks = new Stack<>();
        for (char word : s.toCharArray()) {
            if (map.get(word) == null) {
                stacks.push(word);
            } else {
                if (stacks.isEmpty() || map.get(word) != stacks.pop()) {
                    return false;
                }
            }
        }
        return stacks.isEmpty();

    }


}
