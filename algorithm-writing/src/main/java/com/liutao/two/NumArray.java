package com.liutao.two;

/**
 * Author liutao
 * Date 2020/3/31 7:43 下午
 * Description:
 * Version: 1.0
 * <p>
 * P_303
 **/
public class NumArray {

    private int[] data;

    private int[] dp;

    public NumArray(int[] nums) {
        data = nums;
        dp = new int[data.length];
        int count = 0;
        for (int h = 0; h < data.length; h++) {
            count = count + nums[h];
            dp[h] = count;
        }
    }

    public static void main(String[] args) {
        int[] aaa = {1, 2, 3, 3, -4, 2};

        System.out.println(new NumArray(aaa).sumRange(0, 1));
    }

    /**
     * 区域问题转换
     * f= sum(data[0]-data[j])- sum(data[0]-data[i-1])
     *
     * @param i
     * @param j
     * @return
     */
    public int sumRange(int i, int j) {
        if (i == 0) {
            return dp[j];
        } else {
            return dp[j] - dp[i - 1];
        }
    }


}
