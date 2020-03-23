package com.nishui;

/**
 * @Description 买卖股票的最佳时机
 * @Date 2020/3/19 7:11 上午
 * @Created by yiwen
 */
public class P_00121 {

    public static void main(String[] args) {
        int[] prices = new int[]{7,1,5,3,6,4};
        System.out.println(new P_00121().maxProfit(prices));
        System.out.println(new P_00121().maxProfit2(prices));
    }


    /**
     *
     * @param prices
     * @return
     */
    public int maxProfit2(int[] prices) {
        if (prices == null || prices.length <= 1) {
            return 0;
        }
        int min = prices[0];
        int max = 0;
        for(int price : prices) {
            if (price < min) {
                min = price;
            }
            max = Math.max(max, price - min);
        }
        return max;
    }

    /**
     * 暴力破解
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 1) {
            return 0;
        }

        int earnMoney = 0;

        for (int i = 1; i < prices.length; i++) {
            for (int j = 0; j < i; j++) {
                if (prices[i] - prices[j] > earnMoney) {
                    earnMoney = prices[i] - prices[j];
                }
            }
        }

        return earnMoney;
    }

}
