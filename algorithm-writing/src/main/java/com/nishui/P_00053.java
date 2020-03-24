package com.nishui;

/**
 * @Description 最大子序和
 * @Date 2020/3/23 9:58 下午
 * @Created by yiwen
 */
public class P_00053 {

    public static void main(String[] args) {
        int[] nums = new int[]{-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(new P_00053().maxSubArray(nums));
    }

    public int maxSubArray(int[] nums) {
        int len;
        if (nums == null || (len = nums.length) < 1) {
            return 0;
        }

        int[] dp = new int[len];
        dp[0] = nums[0];
        int ans = nums[0];
        for (int i = 1; i < len; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);

            if (dp[i] > ans) {
                ans = dp[i];
            }
        }
        return ans;
    }

}
