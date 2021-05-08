# 403. 青蛙过河 [动态规划]
from typing import List


class Solution:
    def canCross(self, stones: List[int]) -> bool:
        length = len(stones)
        dp = [[False] * length for _ in range(length)]
        dp[0][0] = True
        for i in range(length):
            for j in range(i - 1, -1, -1):
                k = stones[i] - stones[j]
                if k > j + 1:
                    break
                dp[i][k] = dp[j][k - 1] or dp[j][k] or dp[j][k + 1]

        return dp[length - 1].count(True) > 0
