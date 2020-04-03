package com.liutao.one;

/**
 * Author liutao
 * Date 2020/3/19 7:59 下午
 * Description:
 * Version: 1.0
 **/
public class BestTimeToBuyAndSellStock_121 {

    /**
     * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
     * <p>
     * 如果你最多只允许完成一笔交易（即买入和卖出一支股票一次），设计一个算法来计算你所能获取的最大利润。
     * <p>
     * 注意：你不能在买入股票前卖出股票。
     * <p>
     * <p>
     * <p>
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
     *
     * @param args
     */
    public static void main(String[] args) {

        int[] aaa = {2, 1, 4};
        System.out.println(maxProfitOther(aaa));
    }

    /**
     * 普通解法 第一种 暴力破解
     *
     * @param prices
     * @return
     */
    public static int maxProfit(int[] prices) {
        int count = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            for (int j = i; j < prices.length; j++) {
                if (prices[j] - prices[i] > count) {
                    count = prices[j] - prices[i];
                    System.out.println("打印收益增加的天数,第" + i + "天到第 " + j + "天的收益是" + count);
                }
            }
        }
        return count;
    }

    /**
     *
     * 记录起始点, 每次把最小的起始点给记录下来,
     *
     * @param prices
     * @return
     */
    public static int maxProfitTwo(int[] prices) {
        int count = 0;  // 设置默认值
        int start = 0;

        for (int end = 0; end < prices.length; end++) {
            System.out.println("start:"+start+" end : "+end);
            if (prices[start] > prices[end]) {
                start = end;
            }
            if (count < (prices[end] - prices[start])) {
                count = prices[end] - prices[start];
            }
        }
        return count;
    }

    /**
     *网上的贪心算法
     * 贪心算法，从左向右，维护一个最小值low，与每一天的股票价格做差，差最大的为答案
     * 2,4,5,0
     */
    public static int maxProfitOther(int[] prices) {
            int maxP = 0;
            int low = Integer.MAX_VALUE;
            for(int p : prices) {
                if(p < low) {
                    low = p;
                }
                maxP = Math.max(maxP, p - low);
            }
            return maxP;
        }

        /**
         * 定义一下转换规则，当前天的价格减去前一天的价格，第一天由于没有前一天，规定为 0，用来代表不操作。
         *
         * 数组就转换为 0 6-1 2-6 8-2，也就是 0 5 -4 6。现在的数组的含义就变成了股票相对于前一天的变化了。
         *
         * 现在我们只需要找出连续的和最大是多少就可以了，也就是变成了 53 题。
         *
         * 连续的和比如对应第 3 到 第 6 天加起来的和，那对应的买入卖出其实就是第 2 天买入，第 6 天卖出。
         *
         * 换句话讲，买入卖出和连续的和形成了互相映射，所以问题转换成功。
         *
         * 代码在上边的基础上改一下就可以了。
         * 而这个算法其实叫做 Kadane 算法，如果序列中含有负数，并且可以不选择任何一个数，那么最小的和也肯定是
         * 0，也就是上边的情况，这也是把我们把第一天的浮动当作是 0 的原因。所以 max 初始化成了 0。
         */
        public static int maxProfitOthers(int[] prices){

            int n = prices.length;
            int dp = 0;
            int max = 0;
            for (int i = 1; i < n; i++) {
                int num = prices[i] - prices[i - 1];
                dp = Math.max(dp + num, num);
                max = Math.max(max, dp);
            }
            return max;
        }

}
