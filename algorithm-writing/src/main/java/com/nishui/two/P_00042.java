package com.nishui.two;

/**
 * @Description 接雨水
 * @Date 2020年04月05日 08时25分
 * @Created by yiwen
 */
public class P_00042 {

    public static void main(String[] args) {
        int[] height = new int[]{0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(P_00042.trap(height));
    }

    public static int trap(int[] height) {
        int len;
        int sum = 0;
        if (height == null || (len = height.length) <= 2) {
            return sum;
        }

        int maxLeft = 0;
        int maxRight = 0;
        int left = 1;
        int rigth = len - 2;

        for (int i = 1; i < len - 1; i++) {
            if (height[left - 1] < height[rigth + 1]) {
                maxLeft = Math.max(maxLeft, height[left - 1]);
                if (maxLeft > height[left]) {
                    sum += (maxLeft - height[left]);
                }
                left++;
            } else {
                maxRight = Math.max(maxRight, height[rigth + 1]);
                if (maxRight > height[rigth]) {
                    sum += (maxRight - height[rigth]);
                }
                rigth--;
            }
        }
        return sum;
    }

}
