package com.nishui.arr;

import java.text.BreakIterator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Description 三数之和
 * @Date 2020年04月04日 19时39分
 * @Created by yiwen
 */
public class P_00015 {

    public static void main(String[] args) {
        int[] nums = new int[]{-1, 0, 1, 2, -1, -4};
        for (List<Integer> integers : P_00015.threeSum(nums)) {
            integers.stream().forEach(x -> System.out.print(x));
            System.out.println("");
        }
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        int len;
        if (nums == null || (len = nums.length) < 3) {
            return ans;
        }

        //先排序
        Arrays.sort(nums);
        for (int i = 0; i < len; i++) {
            if (nums[i] > 0) {
                break;
            }
            //去重
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            //左右遍历 移动必须去重
            int leftIdx = i + 1;
            int rightIdx = len - 1;

            while (leftIdx < rightIdx) {
                int sum = nums[i] + nums[leftIdx] + nums[rightIdx];

                if (sum == 0) {
                    ans.add(Arrays.asList(nums[i], nums[leftIdx], nums[rightIdx]));
                    while (leftIdx < rightIdx && nums[leftIdx] == nums[leftIdx + 1]) {
                        leftIdx++;
                    }
                    while (leftIdx < rightIdx && nums[rightIdx] == nums[rightIdx - 1]) {
                        rightIdx++;
                    }
                    leftIdx++;
                    rightIdx--;
                } else if (sum < 0) {
                    leftIdx++;
                } else if (sum > 0) {
                    rightIdx--;
                }
            }
        }
        return ans;
    }
}
