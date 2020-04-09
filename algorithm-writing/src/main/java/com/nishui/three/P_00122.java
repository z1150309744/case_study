package com.nishui.three;

/**
 * @Description 买卖股票的最佳时机 II
 * @Date 2020年04月09日 08时17分
 * @Created by yiwen
 */
public class P_00122 {

    public static void main(String[] args) {
        int[] prices = new int[]{7,1,5,3,6,4};
        System.out.println(new P_00122().maxProfit(prices));
    }

    //贪心
    public int maxProfit(int[] prices) {
        int len;
        int ans = 0;
        if (prices == null || (len = prices.length) <= 1) {
            return ans;
        }

        int pre = prices[0];
        for (int i = 1; i < len; i++) {
            if (prices[i] > pre) {
                ans += prices[i] - pre;
            }
            pre = prices[i];
        }
        return ans;
    }

}
