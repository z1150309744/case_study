package com.nishui.four;

/**
 * @Description 连续子数组的最大和
 * @Date 2020年04月16日 07时59分
 * @Created by yiwen
 */
public class P_00042 {

    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length < 1 || nums.length > Math.pow(10, 5)) {
            throw new IllegalArgumentException("param is error");
        }

        int ans = nums[0];
        int[] dp = new int[nums.length];
        dp[0] = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < -100 || nums[i] > 100) {
                throw new IllegalArgumentException("params is error");
            }

            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            if (dp[i] > ans) {
                ans = dp[i];
            }
        }
        return ans;
    }

}
