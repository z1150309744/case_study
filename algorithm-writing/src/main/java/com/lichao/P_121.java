package com.lichao;

import java.util.Stack;

/**
 * @Author: lichao
 * @Date: 2020-03-17 17:48
 */
class P_121 {

    public static int maxProfit(int[] prices) {

        int top;
        int max = 0;

        if(prices.length == 0){
            return 0;
        }
        top = prices[0];
        for (int i = 1; i < prices.length; i++) {
            if(prices[i] > top){
                max  = (prices[i] - top) > max ? (prices[i] - top) : max;
            }else{
                top  = prices[i];
            }
        }
        return max;
    }




    public static void main(String[] args) {
        int[] input = {7,1,5,3,6,4};
        maxProfit(input);
    }
}