package com.nishui.four;

import java.util.concurrent.*;

/**
 * @Description 完全平方数
 * @Date 2020年04月17日 07时33分
 * @Created by yiwen
 */
public class P_00279 {

    public static void main(String[] args) throws Exception {
        while (true) {
            Thread.sleep(5000);
            ExecutorService threadPool = new ThreadPoolExecutor( 0, 1, 0,
                TimeUnit.SECONDS, new LinkedBlockingQueue<>(1),
                Executors.defaultThreadFactory()
            );

            threadPool.execute(() -> {
                System.out.println("sdf");
            });
            Thread.sleep(5000);
            System.out.println("end");
        }
    }

    public int numSquares(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("params is error");
        }

        /** dp[i]  表示平方和组成正整数为i的个数最少 **/
        int[] dp = new int[n + 1];
        //初始值
        dp[0] = 0;

        for (int i = 1; i <= n; i++) {
            //比较坏的情况就是每次在前面的基础上加1
            dp[i] = dp[i - 1] + 1;
            for (int j = 1; j * j <= i; j++) {
                dp[i] = Math.min(dp[i - j * j] + 1, dp[i]);
            }
        }
        return dp[n];
    }

}
