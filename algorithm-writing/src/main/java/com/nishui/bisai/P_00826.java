package com.nishui.bisai;

import java.util.Arrays;

/**
 * @Description 安排工作以达到最大收益
 * @Date 2020年04月06日 20时54分
 * @Created by yiwen
 */
public class P_00826 {

    public void checkThrow(int[] arr) {
        if (arr == null || arr.length < 1 || arr.length > 10000) {
            throw new IllegalArgumentException("params is error");
        }
    }


    /**
     * 13.99%
     * 35.71%
     * @param difficulty
     * @param profit
     * @param worker
     * @return
     */
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        checkThrow(difficulty);
        checkThrow(profit);
        checkThrow(worker);

        Arrays.sort(worker);

        int ans = 0;
        int curProfit = 0;
        for (int i = 0; i < worker.length; i++) {
            for (int j = 0; j < difficulty.length; j++) {
                if (worker[i] >= difficulty[j]) {
                    curProfit = Math.max(curProfit, profit[j]);
                }
            }
            ans += curProfit;
        }

//        Arrays.sort(worker);
//        int maxProfit = 0;
//        int minDifficultyCursor = 0;
//        for (int i = 0; i < worker.length; i++) {
//
//            for (int j = minDifficultyCursor; j < difficulty.length; j++) {
//                if (worker[i] >= difficulty[j]) {
//                    minDifficultyCursor = j;
//                    if (minDifficultyCursor == difficulty.length - 1) {
//                        maxProfit += profit[minDifficultyCursor];
//                    }
//                } else {
//                    if (j != minDifficultyCursor) {
//                        maxProfit += profit[minDifficultyCursor];
//                    }
//                    break;
//                }
//            }
//
//        }
        return ans;
    }

}
