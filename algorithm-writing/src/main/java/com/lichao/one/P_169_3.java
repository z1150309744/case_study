package com.lichao.one;

/**
 * @Author: lichao
 * @Date: 2020-03-25 21:09
 * <p>
 * 哈希表
 */
public class P_169_3 {


    private static int[] nums;




    public static int majorityElement(int[] nums) {
        P_169_3.nums = nums;
        return majorityElement(0, nums.length - 1);
    }




    public static int majorityElement(int head, int end) {
        if (head == end) {
            return nums[head];
        } else {
            int middle = (head + end) / 2;
            int right = majorityElement(head, middle);
            int left = majorityElement(middle + 1, end);
            if (right == left) {
                return right;
            } else {
                int count = 0;
                for (int i = head; i <= end; i++) {
                    if (nums[i] == right) {
                        count++;
                    }
                }
                if (count > (end - head) / 2) {
                    return right;
                } else {
                    return left;
                }
            }

        }
    }




    public static void main(String[] args) {
        int[] input = {2, 2, 3, 3, 3, 3, 2};
        System.out.println(majorityElement(input));
    }

}
