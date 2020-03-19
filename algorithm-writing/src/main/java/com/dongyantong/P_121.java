package com.dongyantong;

/**
 * @Author: dongyantong
 * @Date: 2020/3/19
 * @link https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/
 */
public class P_121 {
    public static void main(String[] args) {

    }

    //  思路： 最大收益 也就是数组的从左到右的差别最大值  转化为 与最小的值之间的差值最大
    // 贪心算法
    public static int maxProfit(int[] prices) {
        int max = 0;
        int min = Integer.MAX_VALUE;
        for (int price : prices) {
            if (price < min) {
                min = price;
            }
            max = Math.max(max, price - min);

        }
        return max;
    }
}
