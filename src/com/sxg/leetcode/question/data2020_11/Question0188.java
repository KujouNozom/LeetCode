package com.sxg.leetcode.question.data2020_11;

/**
 * @ClassName: com.sxg.leetcode.question.data2020_11.Question0188
 * @Author: Su_N
 * @Date: 2020/11/2 22:54
 * @Description: 动态规划
 * 使用三维的动态规划，dp[i][j][k] i：第i天 j：j次交易 k：1表示持有，0表示未持有
 * dp[i][j][0] = max(dp[i-1][j-1][1] + prices[i],dp[i-1][j][0])
 * dp[i][j][1] = max(dp[i-1][j][1] ,dp[i-1][j-1][0] - prices[i])
 *
 * 我们发现只和前一天的状态有关系都是i-1，因此可以简化为二维数组，dp[j][k]
 * dp[j][0] = max(dp[j][0], dp[j][1] + prices[i])
 * dp[j][1] = max(dp[j][1], dp[j - 1][0] - prices[i])
 *
 * 我们可以再进行一些判断，一共n天，所以交易次数最多n/2次，如果k大于等于 n/2，相当于无限次交易，类似 122 题，可以使用贪心算法
 *
 * 初始化状态dp[j][1] = 无效值（一个很小的负数）,因为初始的时候实际上是第0天（我们优化了时间），这个时候不可能持有股票
 *
 * 作者：Storm
 * 链接：https://leetcode-cn.com/circle/article/qiAgHn/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 *
 *
 * 188. 买卖股票的最佳时机 IV
 *
 * 给定一个整数数组 prices ，它的第 i 个元素 prices[i] 是一支给定的股票在第 i 天的价格。
 *
 * 设计一个算法来计算你所能获取的最大利润。你最多可以完成 k 笔交易。
 *
 * 注意: 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 *
 *
 *
 * 示例 1：
 *
 * 输入：k = 2, prices = [2,4,1]
 * 输出：2
 * 解释：在第 1 天 (股票价格 = 2) 的时候买入，在第 2 天 (股票价格 = 4) 的时候卖出，这笔交易所能获得利润 = 4-2 = 2 。
 *
 * 示例 2：
 *
 * 输入：k = 2, prices = [3,2,6,5,0,3]
 * 输出：7
 * 解释：在第 2 天 (股票价格 = 2) 的时候买入，在第 3 天 (股票价格 = 6) 的时候卖出, 这笔交易所能获得利润 = 6-2 = 4 。
 * 随后，在第 5 天 (股票价格 = 0) 的时候买入，在第 6 天 (股票价格 = 3) 的时候卖出, 这笔交易所能获得利润 = 3-0 = 3 。
 *
 *
 *
 * 提示：
 *
 * 0 <= k <= 109
 * 0 <= prices.length <= 104
 * 0 <= prices[i] <= 1000
 */
public class Question0188 {
    public int maxProfit(int k, int[] prices) {
        if (prices.length == 0) {
            return 0;
        }

        int length = prices.length;
        if (k >= length / 2) {
            return maxProfit(prices);
        }

        int[][] dp = new int[k + 1][2];
        for (int index = 0; index <= k; index++) {
            dp[index][1] = Integer.MIN_VALUE;
        }

        for (int price : prices) {
            for (int j = 1; j <= k; j++) {
                dp[j][1] = Math.max(dp[j][1], dp[j - 1][0] - price);
                dp[j][0] = Math.max(dp[j][0], dp[j][1] + price);
            }
        }

        return dp[k][0];

    }

    public int maxProfit(int[] prices) {
        int profit = 0;
        for (int index = 1; index < prices.length; index++) {
            int tmpProfit = prices[index] - prices[index - 1];
            if (tmpProfit > 0) {
                profit += tmpProfit;
            }
        }
        return profit;
    }
}
