package com.sxg.leetcode.question.data2020_0x.no0301_0350;

/**
 * @ClassName: Question0309
 * @Author: Su_N
 * @Date: 2020/7/16 23:53
 * @Description: 动态规划
 * 使用带状态的动态规划，买入是负收益，卖出是正收益
 *
 * dp[i][0] 表示i天结束之后没有持有股票，并且没有在冷却期
 * dp[i][1] 表示i天卖出股票，结束之后在冷却期
 * dp[i][2] 表示i天结束之后持有股票
 *
 * 转移方程
 * dp[i][0]：因为没有持有股票，并且不再冷却期，所以i当天没有卖出。有两种情况，第一i-1天没有持有，第二，i-1天卖出了,i天冷却期,i天结束不再冷却期
 * dp[i][0] = max(dp[i-1][0],dp[i-1][1])
 * dp[i][1]：天卖出了股票，因此i-1天肯定持有股票,卖出是正收益，加上当天价格
 * dp[i][1] = dp[i-1][2] + prices[i]
 * dp[i][2]：i天结束之后还有股票，两种情况，第一i-1天就持有股票,i天不卖出，第二i-1天没有持有，并且i-1天不再冷却期，i天买入
 * dp[i][2] = max(dp[i-1][2],dp[i-1][0]-prices[i])
 *
 * 初始状态
 * dp[0][0] = 0
 * dp[0][1] = 0 (不存在这种情况，但是也可以甚至为0，因为只有 第二天的0状态 这种情况下才会涉及前一天的1状态，此时只能是第一种情况 dp[1][0] = dp[0][0]也是0）
 * dp[0][2] = -prices[0]
 *
 * 结果
 * max(dp[n][0],dp[n][1],dp[n][2]) 实际不存在dp[n][2]，因为最后一天了，卖出肯定是正收益
 *
 *
 * 309. 最佳买卖股票时机含冷冻期
 *
 * 给定一个整数数组，其中第 i 个元素代表了第 i 天的股票价格 。​
 *
 * 设计一个算法计算出最大利润。在满足以下约束条件下，你可以尽可能地完成更多的交易（多次买卖一支股票）:
 *
 * 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 * 卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。
 *
 * 示例:
 *
 * 输入: [1,2,3,0,2]
 * 输出: 3
 * 解释: 对应的交易状态为: [买入, 卖出, 冷冻期, 买入, 卖出]
 */
public class Question0309 {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }

        int length = prices.length;
        int[][] dp = new int[length][3];
        dp[0][0] = 0;
        dp[0][1] = 0;
        dp[0][2] = -prices[0];

        for (int index = 1; index < length; index++) {
            dp[index][0] = Math.max(dp[index - 1][0], dp[index - 1][1]);
            dp[index][1] = dp[index - 1][2] + prices[index];
            dp[index][2] = Math.max(dp[index - 1][2], dp[index - 1][0] - prices[index]);
        }

        return Math.max(dp[length - 1][0], dp[length - 1][1]);
    }
}
