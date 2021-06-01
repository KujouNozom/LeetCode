# 1473. 粉刷房子 III [动态规划]
from typing import List


class Solution:
    def minCost(self, houses: List[int], cost: List[List[int]], m: int, n: int, target: int) -> int:
        dp = [[[float("inf")] * n for _ in range(target)] for _ in range(m)]
        houses = [c - 1 for c in houses]

        for i in range(m):
            for j in range(target):
                for k in range(n):
                    if houses[i] != -1 and houses[i] != k:
                        continue
                    for k0 in range(n):
                        if k == k0:
                            if i == 0:
                                if j == 0:
                                    dp[i][j][k] = 0
                            else:
                                dp[i][j][k] = min(dp[i][j][k], dp[i - 1][j][k])
                        elif i > 0 and j > 0:
                            dp[i][j][k] = min(dp[i][j][k], dp[i - 1][j - 1][k0])

                    if dp[i][j][k] != float("inf") and houses[i] == -1:
                        dp[i][j][k] += cost[i][k]

        ans = min(dp[m - 1][target - 1])
        return -1 if ans == float("inf") else ans
