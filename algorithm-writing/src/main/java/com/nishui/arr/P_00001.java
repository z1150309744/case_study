package com.nishui.arr;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description 两数之和
 * @Date 2020年04月04日 19时23分
 * @Created by yiwen
 */
public class P_00001 {

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> historyMap = new HashMap<>(nums.length);

        Integer otherIdx;
        for (int i = 0; i < nums.length; i++) {
            int tmp = target - nums[i];
            if ((otherIdx = historyMap.get(tmp)) != null) {
                return new int[]{otherIdx, i};
            }
            historyMap.put(nums[i], i);
        }
        throw new IllegalArgumentException("no result");
    }

}
