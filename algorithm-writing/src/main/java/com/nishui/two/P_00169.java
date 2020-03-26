package com.nishui.two;

/**
 * @Description 多数元素
 * @Date 2020/3/25 7:08 上午
 * @Created by yiwen
 */
public class P_00169 {

    public static void main(String[] args) {
        int[] nums = new int[]{2,2,1,1,1,2,2};
        System.out.println(new P_00169().majorityElement(nums));
    }

    /**
     * 分治
     * 1.数组非空
     * 2.总是存在非空元素
     * @param nums
     * @return
     */
    public int majorityElement(int[] nums) {
        int len;
        if ((len = nums.length) == 2) {
            if (nums[0] == nums[1]) {
                return nums[0];
            } else {
                throw new RuntimeException("no majority");
            }
        }
        if (len == 0) {
            throw new RuntimeException("no majority");
        }
        return majorityElementRec(nums, 0, len - 1);
    }

    public int majorityElementRec(int[] nums, int low, int high) {
        //终止条件
        if (low == high){
            return nums[low];
        }

        //分
        int middle = (high - low) / 2 + low;

        int left = majorityElementRec(nums, low, middle);
        int right = majorityElementRec(nums, middle + 1, high);

        if (left == right) {
            return left;
        }

        //不相等的情况，必须计算此区间内谁的 数 最多
        int leftCount = count(nums, left, low, high);
        int rightCount = count(nums, right, low, high);

        return leftCount > rightCount ? left : right;
    }

    public int count(int[] nums, int num, int low, int high) {
        int count = 0;
        for (int i = low; i <= high; i++) {
            if (nums[i] == num) {
                count++;
            }
        }
        return count;
    }


}

