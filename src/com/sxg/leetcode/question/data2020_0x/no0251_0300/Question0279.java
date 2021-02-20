package com.sxg.leetcode.question.data2020_0x.no0251_0300;

/**
 * @ClassName: Question0279
 * @Author: Su_N
 * @Date: 2020/7/11 22:19
 * @Description: 动态规划
 * f(0) = 0
 * f(i) = min(f(i-k)+1)) k={1,4,9,16,25......}
 *
 *
 * 279. 完全平方数
 *
 * 给定正整数 n，找到若干个完全平方数（比如 1, 4, 9, 16, ...）使得它们的和等于 n。你需要让组成和的完全平方数的个数最少。
 *
 * 示例 1:
 *
 * 输入: n = 12
 * 输出: 3
 * 解释: 12 = 4 + 4 + 4.
 *
 * 示例 2:
 *
 * 输入: n = 13
 * 输出: 2demo
 * 解释: 13 = 4 + 9.
 */
public class Question0279 {
    public static void main(String[] args) {
        Question0279 demo = new Question0279();
        demo.numSquares(12);
    }

    public int numSquares(int n) {
        if (n == 0) {
            return 0;
        }

        int[] dp = new int[n + 1];
        dp[0] = 0;
        for (int index = 1; index <= n; index++) {
            int min = Integer.MAX_VALUE;
            for (int k = 1; k * k <= index; k++) {
                min = Math.min(min, dp[index - k * k] + 1);
            }
            dp[index] = min;
        }

        return dp[n];
    }
}
