package com.liutao.two;

import javax.swing.plaf.IconUIResource;

/**
 * Author liutao
 * Date 2020/4/1 9:02 下午
 * Description:
 * 一条包含字母 A-Z 的消息通过以下方式进行了编码：
 * <p>
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * 给定一个只包含数字的非空字符串，请计算解码方法的总数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "12"
 * 输出: 2
 * 解释: 它可以解码为 "AB"（1 2）或者 "L"（12）。
 * 示例 2:
 * <p>
 * 输入: "226"
 * 输出: 3
 * 解释: 它可以解码为 "BZ" (2 26), "VF" (22 6), 或者 "BBF" (2 2 6) 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/decode-ways
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * Version: 1.0
 **/
public class P_91 {


    public static void main(String[] args) {
        System.out.println('7'-'0');

        System.out.println(new P_91().numDecodings("226"));
    }

    public int numDecodings(String s) {
        char[] arr = s.toCharArray();
        //多加一个, 防止索引越界
        int[] dp = new int[s.length() + 1];
        dp[0] = 1; // 初始化
        dp[1] = arr[0] == '0' ? 0 : 1; //处理为0的情况
        if (s.length() <= 1) {
            return dp[1];
        }
        for (int i = 2; i <= s.length(); i++) {
            int n = (arr[i - 2] - '0') * 10 + (arr[i - 1] - '0');
            if (arr[i - 1] == '0' && arr[i - 2] == '0') {
                return 0;
            }
            if (arr[i - 2] == '0') {
                dp[i] = dp[i - 1];
                continue;
            }
            if (arr[i - 1] == '0') {
                if (n > 26) {
                    return 0;
                }
                dp[i] = dp[i - 2];
                continue;
            }
            if (n > 26) {
                dp[i] = dp[i - 1];
                continue;
            }

            dp[i] = dp[i - 1] + dp[i - 2];

        }
        return dp[dp.length - 1];
    }
}
