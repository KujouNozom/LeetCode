package com.sxg.leetcode.question.data2020_0x.no0301_0350;

import java.util.Arrays;

/**
 * @ClassName: Question0322
 * @Author: Su_N
 * @Date: 2020/7/21 23:12
 * @Description: 动态规划
 * f(i)表示组成金额i需要最少的金币
 * f(i) = f(i-c) + 1 C循环所有的金额
 * 初始化f(0) = 0
 *
 * 322. 零钱兑换
 *
 * 给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回 -1。
 *
 *
 *
 * 示例 1:
 *
 * 输入: coins = [1, 2, 5], amount = 11
 * 输出: 3
 * 解释: 11 = 5 + 5 + 1
 *
 * 示例 2:
 *
 * 输入: coins = [2], amount = 3
 * 输出: -1
 *
 *
 *
 * 说明:
 * 你可以认为每种硬币的数量是无限的。
 */
public class Question0322 {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);

        dp[0] = 0;
        for (int index = 1; index <= amount; index++) {
            int min = amount + 1;
            for (int coin : coins) {
                if (index - coin >= 0) {
                    min = Math.min(dp[index - coin], min);
                }

                dp[index] = min + 1;
            }
        }

        return dp[amount] > amount ? -1 : dp[amount];
    }
}
