package com.nishui.two;

import java.util.Arrays;

/**
 * @Description 最接近的三数之和
 * @Date 2020年04月05日 23时13分
 * @Created by yiwen
 */
public class P_00016 {

    public static void main(String[] args) {

    }

    /**
     *
     * @param nums
     * @param target
     * @return
     */
    public int threeSumClosest(int[] nums, int target) {
        int len;
        if (nums == null || (len = nums.length) < 3) {
            throw new IllegalArgumentException("params is error");
        }
        Arrays.sort(nums);
        int ans = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < len; i++) {
            int leftCursor = i + 1;
            int rightCursor = len - 1;

            while (leftCursor < rightCursor) {
                int sum = nums[i] + nums[leftCursor] + nums[rightCursor];

                if (Math.abs(sum - target) < Math.abs(ans - target)) {
                    ans = sum;
                }
                /** 判断移动 **/
                if (sum > target) {
                    rightCursor--;
                } else if (sum < target) {
                    leftCursor--;
                } else {
                    return ans;
                }
            }
        }
        return ans;
    }
}
