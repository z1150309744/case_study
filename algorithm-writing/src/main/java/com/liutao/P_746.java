package com.liutao;

/**
 * Author liutao
 * Date 2020/3/27 9:22 下午
 * Description:
 * Version: 1.0
 **/
public class P_746 {
    public static void main(String[] args) {

        int[] a = {10, 15, 20};
        System.out.println(minCostClimbingStairs(a));
    }

    public static int minCostClimbingStairs(int[] cost) {
        int length = cost.length;
        int[] dp = new int[length];
        dp[0]=cost[0];
        dp[1]=cost[1];
        for (int i = 2; i < length; i++) {
            dp[i] = Math.min(cost[i - 1], cost[i - 2]) + cost[i];
        }
        return Math.min(dp[length-1],dp[length-2]);
    }




    public static int minCostClimbingStairs1(int[] cost) {
        int f1 = 0; // 记录历史的值
        int f2 = 0;  //记录最新一次总值的
        for (int i = 0; i < cost.length; i++) {
            int count = cost[i] + Math.min(f1, f2); //记录本次最小的部署值
            f1 = f2;
            f2 = count;
        }
        return Math.min(f1, f2);
    }

    public static int minCostClimbingStairs2(int[] cost) {
        int length = cost.length;
        for (int i = 2; i < length; i++) {
            cost[i] = Math.min(cost[i - 1], cost[i - 2]) + cost[i];
        }
        return Math.min(cost[length-1],cost[length-2]);
    }


}
