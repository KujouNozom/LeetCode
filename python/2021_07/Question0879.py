# 879. 盈利计划 [动态规划]
from typing import List


class Solution:
    def profitableSchemes(self, n: int, minProfit: int, group: List[int], profit: List[int]) -> int:
        len_work = len(profit)
        dp = [[[0] * (minProfit + 1) for _ in range(n + 1)] for _ in range(len_work + 1)]
        dp[0][0][0] = 1
        mod = 10 ** 9 + 7

        for i in range(1, len_work + 1):
            staff_count, profit_count = group[i - 1], profit[i - 1]
            for j in range(n + 1):
                for k in range(minProfit + 1):
                    dp[i][j][k] = dp[i - 1][j][k]
                    if j >= staff_count:
                        dp[i][j][k] += dp[i - 1][j - staff_count][max(0, k - profit_count)]
                    dp[i][j][k] %= mod
        return sum(dp[len_work][j][minProfit] for j in range(n + 1)) % mod
