package com.dongyantong;

/**
 * @Author: dongyantong
 * @Date: 2020/3/27
 */
public class P_746 {
    public static void main(String[] args) {

    }

    public int minCostClimbingStairs(int[] cost) {
        int[] result = new int[cost.length];
        result[0] = cost[0];
        result[1] = cost[1];
        for (int i = 2; i < cost.length + 1; i++) {
            // 走到头了
            int min =  Math.min(result[i - 1], result[i - 2]);
            if (i == cost.length) {
                return min;
            }
            result[i] = min  + cost[i];
        }
        return -1;
    }
}
