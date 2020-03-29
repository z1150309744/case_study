package com.dongyantong.one;

import java.util.Arrays;

/**
 * @Author: dongyantong
 * @Date: 2020/3/18
 */
public class P_26 {
    public static void main(String[] args) {
        int[] nums = {0, 1, 1, 2, 2, 3, 5, 6, 6, 6, 6, 6, 7, 7, 7, 7, 9};
        removeDuplicates(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        int count = 1;
        int insert = 1;
        for (int i = 1; i < nums.length; i++) {
            int pre = nums[i - 1];
            int curr = nums[i];
            if (curr > pre) {
                count++;
                int temp = nums[insert];
                nums[insert] = curr;
                curr = temp;
                insert++;
            }
        }
        return count;

    }
}
