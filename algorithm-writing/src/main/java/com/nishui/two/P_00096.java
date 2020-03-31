package com.nishui.two;

/**
 * @Description 不同的二叉搜索树
 * @Date 2020年03月29日 11时35分
 * @Created by yiwen
 */
public class P_00096 {

    public static void main(String[] ardps) {
        System.out.println(new P_00096().numTrees(3));
    }

    public int numTrees(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }

        /**
         * f(i) 表示以 i 为根节点的二叉树  dp(n) 表示 n个节点存在的二叉排序树
         * dp(n) = f(1) + f(2) + f(3) + .... + f(n)
         *
         * f(i) = dp(i - 1) * dp(n - i)
         * 
         * dp(n) = dp(0) ∗ dp(n−1) + dp(1) ∗ dp(n−2) + ... + dp(n−1) ∗ dp(0)
         *
         * dp(0) = 1; dp(1) = 1
         *
         * dp(2) = dp(0) * dp(1) + dp(1) * dp(0)
         *
         * dp(3) = dp(0) * dp(2) + dp(1) * dp(0) + dp(2) * dp(0)
         *
         */
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;

        /** 第一层for 表示i个节点的二叉排序树有多少个 **/
        for (int i = 2; i < n + 1; i++) {
            /** 剩下的也需要符合 dp(n) = dp(0) ∗ dp(i−1) + ... + dp(i−1) ∗ dp(0) **/
            for (int j = 1; j < i + 1; j++) {
                dp[i] += dp[j - 1] * dp[i - j];
            }
        }

        return dp[n];
    }

}
