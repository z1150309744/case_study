package com.lichao;

/**
 * @Author: lichao
 * @Date: 2020-03-27 19:52
 */
public class P_746 {

    public static int minCostClimbingStairs(int[] cost) {
        for (int i = 2; i < cost.length; i++) {
            cost[i] = Math.min(cost[i - 1], cost[i-2]) + cost[i];
        }
        return Math.min(cost[cost.length - 1], cost[cost.length - 2]);

    }




    public static void main(String[] args) {
        int[] inout = {10, 15, 20};
        System.out.println(minCostClimbingStairs(inout));

    }
}
