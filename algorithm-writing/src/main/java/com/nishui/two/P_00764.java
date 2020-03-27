package com.nishui.two;

/**
 * @Description 使用最小花费爬楼梯
 * @Date 2020/3/27 7:23 上午
 * @Created by yiwen
 */
public class P_00764 {

    public static void main(String[] args) {
       int[] cost = new int[]{10, 15, 20};
        System.out.println(new P_00764().minCostClimbingStairs2(cost));
    }

    /**
     * dp2
     * @param cost
     * @return
     */
    public int minCostClimbingStairs2(int[] cost) {
        int len;
        if (cost == null || (len = cost.length) == 0) {
            return 0;
        }

        int[] dp = new int[len + 3];
        for (int i = 2; i < len + 2; i++) {
            dp[i] = Math.min(dp[i - 1], dp[i - 2]) + cost[i - 2];
        }

        dp[len + 2] = Math.min(dp[len + 1], dp[len]);
        return dp[len + 2];
    }

    /**
     * dp
     * @param cost
     * @return
     */
    public int minCostClimbingStairs(int[] cost) {
        int len;
        if (cost == null || (len = cost.length) == 0) {
            return 0;
        }

        int[] dp = new int[len];
        int min = 0;

        /** 初始化状态 **/
        dp[0] = 0;
        if (len > 1) {
            dp[1] = Math.min(cost[0], cost[1]);
            min += dp[1];
        } else {
            return dp[0];
        }

        for (int i = 2; i < len; i++) {
            dp[i] = Math.min(dp[i - 1], dp[i - 2] + cost[i]);
            min += dp[i];
        }

        return min;
    }

}
