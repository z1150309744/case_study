package com.liutao;

/**
 * Author liutao
 * Date 2020/3/24 8:00 下午
 * Description:
 * Version: 1.0
 **/
public class P_53 {

    public static void main(String[] args) {

        //4,-1,2,1  59,26,-53,58,97
        int[] aaa = {31,-41,59,26,-53,58,97,-93,-23,84};
        System.out.println(new P_53().maxSubArray(aaa));
    }

    /**
     * 缺点分析: 思想是动态规划, 缺少空间重复利用的思想, 导致额外使用临时空间存储,并且增加了判断逻辑
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        int maxCount = nums[0];
        int linshiCount = nums[0];
        for (int i = 1; i < nums.length; i++) {
            System.out.println("i为"+i+"linshicount:"+linshiCount);
            int number = nums[i];
            if (number < 0 && linshiCount <= 0) {
                System.out.println("111111");
                if (number > maxCount) {
                    maxCount = number;
                }
                linshiCount = 0;
                continue;
            }
            //如果历史的数值小于目前的值, 则重新开始进行临时值的累加
            if (linshiCount < number && linshiCount < 0) {
                System.out.println("222222");
                //如果此时的值大于最大值,则更新最大值
                if (number > maxCount) {
                    maxCount = number;
                }
                if (number > 0) {
                    linshiCount = number;
                } else {
                    linshiCount = 0;
                }

            } else {
                System.out.println("3333333");
                //继续累加
                int newCount = linshiCount + number;
                //更新临时和的值
                linshiCount = newCount;
                //如果子串大于最大值,则进行更新
                if (newCount > maxCount) {
                    maxCount = newCount;
                }
            }
        }

        return maxCount;
    }

    /**
     * 重复利用数组空间,减少了逻辑判断
     *
     * @param nums
     * @return
     */
    public int maxSubArray01(int[] nums) {
        int n = nums.length, maxSum = nums[0];
        for (int i = 1; i < n; ++i) {
            if (nums[i - 1] > 0) {
                nums[i] += nums[i - 1];
            }
            maxSum = Math.max(nums[i], maxSum);
        }
        return maxSum;

    }


}
