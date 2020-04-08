package com.nishui.two;

import sun.jvm.hotspot.memory.PlaceholderEntry;

/**
 * @Description 寻找两个有序数组的中位数
 * @Date 2020年04月05日 18时57分
 * @Created by yiwen
 */
public class P_00004 {

    public static void main(String[] args) {

    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        boolean bothIsNull = nums1 == null && nums2 == null;
        boolean bothIsEmpty = nums1.length == 0 && nums2.length == 0;
        if (bothIsNull || bothIsEmpty) {
            throw new IllegalArgumentException("Unreasonable parameters");
        }

        int n = nums1.length, m = nums2.length;
        int len = n + m;

        int left = -1, right = -1;
        int leftIdx = 0, rightIdx = 0;

        for (int i = 0; i <= len / 2; i++) {
            left = right;
            if (leftIdx < n && (rightIdx == m || nums1[leftIdx] < nums2[rightIdx])) {
                right = nums1[leftIdx];
                leftIdx++;
            } else {
                right = nums2[rightIdx];
                rightIdx++;
            }
        }

        if ((len & 1) == 0) {
            return (left + right) / 2;
        } else {
            return right;
        }
    }

}
