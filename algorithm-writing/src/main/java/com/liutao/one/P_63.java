package com.liutao.one;

/**
 * Author liutao
 * Date 2020/3/29 2:42 下午
 * Description:
 * 假设把某股票的价格按照时间先后顺序存储在数组中，请问买卖该股票一次可能获得的最大利润是多少？
 * 示例 1:
 * <p>
 * 输入: [7,1,5,3,6,4]
 * 输出: 5
 * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
 * 注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格。
 * 示例 2:
 * <p>
 * 输入: [7,6,4,3,1]
 * 输出: 0
 * 解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/gu-piao-de-zui-da-li-run-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * Version: 1.0
 **/
public class P_63 {


    public static void main(String[] args) {
        int[] aaa = {7, 1, 5, 3, 6, 4};
        System.out.println(maxProfit(aaa));
    }

    /**
     * 问题转换 , 求最大子序和
     *
     * @param prices
     * @return
     */
    public static int maxProfit(int[] prices) {
        if(prices.length==0){
            return 0;
        }
        //边界值排除
        if (prices.length == 1) {
            return 0;
        }
        int[] newPrices = new int[prices.length];
        //重建数组-->问题转换,求最大子序和
        for (int i = 1; i < prices.length; i++) {
            newPrices[i] = prices[i] - prices[i - 1];
        }
        newPrices[0] = 0;
        for (int i = 0; i < newPrices.length; i++) {
            System.out.print(newPrices[i]);
            System.out.print(",");
        }
        System.out.println();
        System.out.println("======");

        int ans = 0; //最开始是0

        int sum = 0;
        for (int i = 1; i < newPrices.length; i++) {
            sum = Math.max(sum + newPrices[i], newPrices[i]);
            ans = Math.max(sum, ans);
        }
        return ans;

    }


}
