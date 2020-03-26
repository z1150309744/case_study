package com.lichao;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: lichao
 * @Date: 2020-03-25 21:09
 *
 *  哈希表
 */
public class P_169_2 {

    public static int majorityElement(int[] nums) {
        Integer tag = nums.length / 2;
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0)+1);
            if (map.get(num) > tag) {
                return num;
            }
        }
        return 0;
    }




    public static void main(String[] args) {
        int[] input = {3,2,3};
        System.out.println(majorityElement(input));
    }

}
