package com.sxg.leetcode.question.data2020_0x.no0101_0150;

/**
 * @ClassName: Question0121
 * @Author: Su_N
 * @Date: 2020/10/20 22:43
 * @Description: 动态规划
 * dp[i] 表示前 i 天获取的最大利润
 * 初始状态：dp[0] = 0
 * dp[i] = max(dp[i-1],prices[i] - min(dp[j], 0 <= j < i))
 * 我们使用 min 保存当前最小值，代替 min(dp[j], 0 <= j < i)
 *
 * 121. 买卖股票的最佳时机
 *
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 *
 * 如果你最多只允许完成一笔交易（即买入和卖出一支股票一次），设计一个算法来计算你所能获取的最大利润。
 *
 * 注意：你不能在买入股票前卖出股票。
 *
 *
 *
 * 示例 1:
 *
 * 输入: [7,1,5,3,6,4]
 * 输出: 5
 * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
 * 注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格；同时，你不能在买入前卖出股票。
 *
 * 示例 2:
 *
 * 输入: [7,6,4,3,1]
 * 输出: 0
 * 解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
 */
public class Question0121 {
    public int maxProfit(int[] prices) {
        int length = prices.length;
        if (length < 2) {
            return 0;
        }
        int[] dp = new int[length];
        int min = prices[0];
        dp[0] = 0;

        for (int index = 1; index < length; index++) {
            int value = prices[index];
            dp[index] = Math.max(dp[index - 1], value - min);
            min = Math.min(min, value);
        }

        return dp[length - 1];
    }
}
