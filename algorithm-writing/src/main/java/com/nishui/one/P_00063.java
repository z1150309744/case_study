package com.nishui.one;

/**
 * @Description 股票的最大利润
 * @Date 2020年03月29日 10时23分
 * @Created by yiwen
 */
public class P_00063 {

    public static void main(String[] args) {
        int[] prices = new int[]{7,1,5,3,6,4};
        System.out.println(new P_00063().maxProfit(prices));

    }

    public int maxProfit(int[] prices) {
        int len;
        if (prices == null || (len = prices.length) <= 1) {
            return 0;
        }

        /** 初始化 状态 **/
        int max = 0;
        int minPrice = prices[0];

        for (int i = 1; i < len; i++) {
            /** 状态转移方程式 **/
            max = Math.max(prices[i] - minPrice, max);
            minPrice = Math.min(prices[i], minPrice);
        }

        return max;
    }

}
