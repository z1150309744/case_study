package com.nishui.one;

/**
 * @Description 删除排序数组中的重复项
 * @Date 2020/3/18 8:00 上午
 * @Created by yiwen
 */
public class P_00026 {

    public static void main(String[] args) {
        P_00026 p_26 = new P_00026();

        int[] nums = {0,0,1,1,1,2,2,3,3,4};

        System.out.println(p_26.removeDuplicatesByLeetCode(nums));
    }

    public int removeDuplicatesByLeetCode(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int slow = 0;
        int fast = 1;
        while (fast < nums.length) {
            if (nums[slow] != nums[fast]) {
                if (fast - slow > 1) {
                    nums[slow + 1] = nums[fast];
                }
                slow++;
            }
            fast++;
        }
        return slow + 1;
    }

    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int numsLength = nums.length;
        int compare = nums[0];

        for (int i = 1; i < numsLength; i++) {
            if (compare == nums[i]) {
                moveForwardABitOfArray(i, nums, numsLength);
                numsLength--;
                i--;
            } else {
                compare = nums[i];
            }
        }
        return numsLength;
    }

    public void moveForwardABitOfArray(int stopIndex, int[] nums, int endIndex) {
        for (int i = stopIndex; i < endIndex - 1; i++) {
            nums[i] = nums[i + 1];
        }
    }


}
