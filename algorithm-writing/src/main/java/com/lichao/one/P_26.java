package com.lichao.one;

/**
 * @Author: lichao
 * @Date: 2020-03-18 20:38
 */
class P_26 {
    public static int removeDuplicates(int[] nums) {

        int top = 0;
        for (int i = 1; i < nums.length; i++) {
            if(nums[top] == nums[i]){
                continue;
            }else{
                nums[++top] = nums[i];
            }
        }
        return top + 1;
    }




    public static void main(String[] args) {

        int[] input = {0,0,1,1,1,2,2,3,3,4};
        System.out.println(removeDuplicates(input));

    }
}
