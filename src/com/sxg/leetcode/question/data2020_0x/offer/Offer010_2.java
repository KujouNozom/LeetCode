package com.sxg.leetcode.question.data2020_0x.offer;

/**
 * @ClassName: Offer010_2
 * @Author: Su_N
 * @Date: 2020/10/28 20:41
 * @Description: 动态规划，菲波那切数列
 * 剑指 Offer 10- II. 青蛙跳台阶问题
 *
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。求该青蛙跳上一个 n 级的台阶总共有多少种跳法。
 *
 * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
 *
 * 示例 1：
 *
 * 输入：n = 2
 * 输出：2
 *
 * 示例 2：
 *
 * 输入：n = 7
 * 输出：21
 *
 * 示例 3：
 *
 * 输入：n = 0
 * 输出：1
 *
 * 提示：
 *
 * 0 <= n <= 100
 */
public class Offer010_2 {
    public int numWays(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;

        for (int index = 2; index <= n; index++) {
            dp[index] = (dp[index - 1] + dp[index - 2]) % 1000000007;
        }

        return dp[n];
    }
}
