package com.nishui.three;

import java.util.Arrays;

/**
 * @Description 任务调度器
 * @Date 2020年04月10日 09时57分
 * @Created by yiwen
 */
public class P_00621 {

    public static void main(String[] args) {
        char[] tasks = new char[]{'A','A','A','B','B','B'};
        System.out.println(new P_00621().leastInterval2(tasks, 2));
    }

    /**
     * 设计
     * @param tasks
     * @param n
     * @return
     */
    public int leastInterval2(char[] tasks, int n) {
        int len;
        if (tasks == null || (len = tasks.length) < 1 || len > 10000) {
            throw new IllegalArgumentException("params is errors");
        }

        if (n < 0 || n > 100) {
            throw new IllegalArgumentException("params is errors");
        }

        int[] map = new int[26];
        for(char c : tasks) {
            map[c - 'A']++;
        }

        Arrays.sort(map);
        int maxVal = map[25] - 1;
        int idle = maxVal * n;

        for (int i = 24; i >=0; i--) {
            idle -= Math.min(map[i], maxVal);
        }

        return idle > 0 ? idle + len : len;

    }

    //贪心
    public int leastInterval(char[] tasks, int n) {
        int len;
        if (tasks == null || (len = tasks.length) < 1 || len > 10000) {
            throw new IllegalArgumentException("params is errors");
        }

        if (n < 0 || n > 100) {
            throw new IllegalArgumentException("params is errors");
        }

        int[] tasksArr = new int[26];
        for(char c : tasks) {
            tasksArr[c - 'A']++;
        }

        Arrays.sort(tasksArr);
        int times = 0;

        while (tasksArr[25] > 0) {
            int i = 0;
            while (i <= n) {
                //提前结束
                if (tasksArr[25] == 0) {
                    break;
                }

                if (i < 26 && tasksArr[25 - i] >= 1) {
                    tasksArr[25 - i]--;
                }

                times++;
                i++;
            }
            Arrays.sort(tasksArr);
        }
        return times;
    }

}
