package com.dongyantong.one;

/**
 * @Author: dongyantong
 * @Date: 2020/3/24
 */
public class P_70 {
    public static void main(String[] args) {

    }
    public int climbStairs(int n) {
        if(n <= 1){
            return n;
        }
        int []dp = new int[n +1];
        dp[1] = 1;
        dp[2] = 2;
        for(int i = 3 ; i <= n; i++){
            dp[i] = dp[i -1] + dp[i -2];
        }
        return dp[n];
    }
}
