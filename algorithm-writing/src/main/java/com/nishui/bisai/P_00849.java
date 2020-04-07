package com.nishui.bisai;

/**
 * @Description 到最近的人的最大距离
 * @Date 2020年04月06日 20时06分
 * @Created by yiwen
 */
public class P_00849 {
    public static void main(String[] args) {

        int[] seats = new int[] {1,0,0,0,1,0,1};
        System.out.println(new P_00849().maxDistToClosest(seats));

    }

    /**
     * 64.84%\7.14%
     * @param seats
     * @return
     */
    public int maxDistToClosest(int[] seats) {
        int len;
        if (seats == null || (len = seats.length) <= 1) {
            throw new IllegalArgumentException("params is error");
        }

        int leftRecent = -1, rightRecent = 0;
        int ans = 0;

        for (int i = 0; i < len; i++) {
            if (seats[i] == 0) {
                //需要更新right
                while (rightRecent < i || rightRecent < len && seats[rightRecent] == 0) {
                    rightRecent++;
                }

                //计算离的最远的距离是左边还是右边
                int tmp;
                if (leftRecent == -1 && rightRecent == len) {
                    throw new IllegalArgumentException(" ");
                } else if (leftRecent == -1){
                    tmp = rightRecent - i;
                } else if (rightRecent == len) {
                    tmp = i - leftRecent;
                } else {
                    tmp = Math.min(i - leftRecent, rightRecent - i);
                }
                ans = Math.max(ans, tmp);
            } else {
                leftRecent = i;
            }
        }
        return ans;
    }
}
