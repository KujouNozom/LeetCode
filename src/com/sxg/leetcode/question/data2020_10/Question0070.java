package com.sxg.leetcode.question.data2020_10;

/**
 * @ClassName: Question0070
 * @Author: Su_N
 * @Date: 2020/10/28 20:44
 * @Description: 70. 爬楼梯 [动态规划，菲波那切数列]
 */
public class Question0070 {
    public int climbStairs(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;

        for (int index = 2; index <= n; index++) {
            dp[index] = (dp[index - 1] + dp[index - 2]);
        }

        return dp[n];
    }
}
