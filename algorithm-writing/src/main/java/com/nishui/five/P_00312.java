package com.nishui.five;

import java.util.Date;

/**
 * @Description 戳气球
 * @Date 2020年04月21日 09时47分
 * @Created by yiwen
 */
public class P_00312 {

    // dp
    public int maxCoins(int[] nums) {
        int len;
        if (nums == null || (len = nums.length) < 0 || len >  500) {
            throw new IllegalArgumentException("params is error");
        }

        //填充原来数组的左右两边都为1，这样方便计算处理，否者还需要考虑临界值
        int[] newNums = new int[len + 2];
        newNums[0] = 1;
        newNums[len + 1] = 1;
        for (int i = 0; i < len; i++) {
            newNums[i + 1] = nums[i];
        }
        //重新定义Len
        len = newNums.length;

        // dp[left][rigth] 表示 left -> right  之间的气球最大值，左右开区间
        // dp[left][right]  = dp[left][k] + dp[k][right] + max{range k in (left, right)} * nums[left] * nums[right]
        int[][] dp = new int[len][len];

        //需要按长度进行dp数组的填充
        for (int interval = 2; interval < len; interval++) {
            for (int left = 0; left < len - interval; left++) {
                int right = left + interval;
                for (int k = left + 1; k < right; k++) {
                    dp[left][right] = Math.max(dp[left][right],
                        dp[left][k] + dp[k][right] + newNums[left] * newNums[right] * newNums[k]);
                }
            }
        }
        return dp[0][len -1];
    }

}
