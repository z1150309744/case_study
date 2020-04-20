package com.nishui.four;

import javax.swing.plaf.basic.BasicButtonUI;
import java.util.*;

/**
 * @Description 子集
 * @Date 2020年04月14日 10时25分
 * @Created by yiwen
 */
public class P_00078 {
    public static void main(String[] args) {
        new P_00078().subsets(new int[] {1, 2});
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        if (nums == null || nums.length <= 0) {
            return result;
        }

        for (int num : nums) {
            List<List<Integer>> subList = new ArrayList<>();
            for (List<Integer> tmpList : result) {
                subList.add(new ArrayList<Integer>(tmpList) {
                    {
                        add(num);
                    }
                });
            }

            for (List<Integer> tmpList : subList) {
                result.add(tmpList);
            }
        }
        return result;
    }

}
