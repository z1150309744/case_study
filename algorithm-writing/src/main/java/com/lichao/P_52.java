package com.lichao;

/**
 * describe: 定义一个opt数组opt[i] 表示以ith元素结束时的最大子序和;
 * opt[i] = max(opt[i-1]+nums[i],nums[i]) 选择最大的那个opt[i]作为结果返回
 *
 * @author lichao
 * @date 2019/03/17
 */
class P_52 {
    public static int maxSubArray(int[] nums) {
        if(null == nums || nums.length == 0){
            throw new RuntimeException("input error");
        }

        int n = nums.length;
        int [] db = new int[n];

        db[0] = nums[0];
        int max = nums[0];
        for(int i = 1; i < nums.length; i++){
            int temp;
            if(nums[i] < (temp = nums[i] + db[i - 1])){
                db[i] = temp;
            }else{
                db[i] = nums[i];
            }
            if(db[i] > max){
                max = db[i];
            }

        }

        return max;
    }

    public static void main(String [] args){
        int [] input = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray(input));
    }
}