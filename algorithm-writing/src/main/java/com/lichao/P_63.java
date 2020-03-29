package com.lichao;

/**
 * describe: 动态规划思想。每一格的路径数=该格上面格子的路径数+该格左边格子的路径数。（第一排和第一列的单独考虑）
 *
 * @author lichao
 * @date 2019/03/17
 */
class P_63 {
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