# 474. 一和零 [动态规划]
import collections
from typing import List


class Solution:
    def findMaxForm(self, strs: List[str], m: int, n: int) -> int:
        length = len(strs) + 1
        dp = [[[0] * (n + 1) for _ in range(m + 1)] for _ in range(length)]
        for i in range(1, length):
            num_counts = collections.Counter(strs[i - 1])
            zero_count, one_count = num_counts.get('0', 0), num_counts.get('1', 0)
            for j in range(m + 1):
                for k in range(n + 1):
                    if zero_count > j or one_count > k:
                        dp[i][j][k] = dp[i - 1][j][k]
                    else:
                        dp[i][j][k] = max(dp[i - 1][j][k], dp[i - 1][j - zero_count][k - one_count] + 1)

        return dp[length - 1][m][n]
