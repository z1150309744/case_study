package com.liutao.three;

/**
 * Author liutao
 * Date 2020/4/6 8:02 下午
 * Description:
 * Version: 1.0
 **/
public class P_849 {

    public static void main(String[] args) {
        int[] dp = {0,0,1,0,1};

        System.out.println(maxDistToClosest(dp));
    }


    /**
     * 在一排座位（ seats）中，1 代表有人坐在座位上，0 代表座位上是空的。
     * <p>
     * 至少有一个空座位，且至少有一人坐在座位上。
     * <p>
     * 亚历克斯希望坐在一个能够使他与离他最近的人之间的距离达到最大化的座位上。
     * <p>
     * 返回他到离他最近的人的最大距离。
     * <p>
     * 示例 1：
     * <p>
     * 输入：[1,0,0,0,1,0,1]
     * 输出：2
     * 解释：
     * 如果亚历克斯坐在第二个空位（seats[2]）上，他到离他最近的人的距离为 2 。
     * 如果亚历克斯坐在其它任何一个空位上，他到离他最近的人的距离为 1 。
     * 因此，他到离他最近的人的最大距离是 2 。
     * 示例 2：
     * <p>
     * 输入：[1,0,0,0]
     * 输出：3
     * 解释：
     * 如果亚历克斯坐在最后一个座位上，他离最近的人有 3 个座位远。
     * 这是可能的最大距离，所以答案是 3 。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/maximize-distance-to-closest-person
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * [0,1]
     */

    public static int maxDistToClosest(int[] seats) {

        int data = 0;
        int maxCount = 0;
        int left = 0;
        boolean leftCount = true;
        for (int i = 0; i < seats.length; i++) {
            if (i == 0) {
                if (seats[i] == 0) {
                    seats[i] = 1;
                    maxCount = 1;
                    left = 1;
                } else {
                    seats[i] = 0;
                    leftCount = false;
                }
            } else {
                if (seats[i] == 0) {
                    int count = seats[i - 1] + 1;
                    seats[i] = count;
                    if (count > maxCount) {
                        maxCount = count;
                    }
                } else {
                    seats[i] = 0;
                    leftCount = false;
                }
            }
            if (leftCount) {
                left = seats[i];
            }
            data = Math.max(data, maxCount % 2 == 0 ? maxCount / 2 : maxCount / 2 + 1);
        }
        int right = seats[seats.length - 1];
        //处理开头的情况/处理开头结尾的情况
        return Math.max(Math.max(right, left), data);
    }


    private static void print(int[] dp) {
        System.out.println("========");
        for (int i = 0; i < dp.length; i++) {
            System.out.print(dp[i]);
            System.out.print(" ");

        }
        System.out.println();
        System.out.println("========");
    }
}
