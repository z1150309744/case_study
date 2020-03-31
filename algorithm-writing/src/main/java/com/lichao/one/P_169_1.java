package com.lichao.one;


/**
 * @Author: lichao
 * @Date: 2020-03-25 18:52
 *
 *  优化的 快排
 */
class P_169_1 {

    private static int[] nums;

    private static int middle;




    public static int majorityElement(int[] nums) {
        int head = 0;
        int end = nums.length - 1;
        // 3 4
        P_169_1.middle = nums.length / 2;
        P_169_1.nums = nums;
        return majorityElement(head, end);
    }




    public static int majorityElement(int head, int end) {
        int old_head = head;
        int old_end = end;
        while (head < end) {
            // 3.2.4.5.3.7.1
            while (head < end && nums[head] <= nums[end]) {
                end--;
            }
            swap(head, end);
            while (head < end && nums[head] <= nums[end]) {
                head++;
            }
            swap(head, end);
        }
        if (head == middle) {
            return nums[head];
        } else if (head < middle) {
            return majorityElement(head + 1, old_end);
        } else {
            return majorityElement(old_head, head - 1);
        }
    }




    public static void swap(int head, int end) {
        if (head != end) {
            int temp = nums[head];
            nums[head] = nums[end];
            nums[end] = temp;
        }
    }




    public static void main(String[] args) {
        int[] input = {3, 2, 3};
        System.out.println(majorityElement(input));
    }
}