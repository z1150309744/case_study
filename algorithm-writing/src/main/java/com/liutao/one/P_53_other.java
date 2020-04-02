package com.liutao.one;

/**
 * Author liutao
 * Date 2020/3/24 8:58 下午
 * Description:
 * Version: 1.0
 **/
public class P_53_other {
    public static void main(String[] args) {



    }

    /**
     * 重复利用数组空间,减少了逻辑判断
     *
     * @param nums
     * @return
     */
    public int maxSubArray01(int[] nums) {
        int n = nums.length, maxSum = nums[0];
        for (int i = 1; i < n; ++i) {
            if (nums[i - 1] > 0) {
                nums[i] += nums[i - 1];
            }
            maxSum = Math.max(nums[i], maxSum);
        }
        return maxSum;

    }


}
