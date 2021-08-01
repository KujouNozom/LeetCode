# LCP 07. 传递信息 [动态规划]
import collections

from typing import List


class Solution:
    def numWays(self, n: int, relation: List[List[int]], k: int) -> int:
        end_index = collections.defaultdict(list)
        for edge in relation:
            end_index[edge[1]].append(edge[0])

        dp = [[0] * n for _ in range(k + 1)]
        dp[0][0] = 1
        for i in range(1, k + 1):
            for end, start_list in end_index.items():
                dp[i][end] = sum([dp[i - 1][start] for start in start_list])

        return dp[k][n - 1]


print(Solution().numWays(n=5, relation=[[0, 2], [2, 1], [3, 4], [2, 3], [1, 4], [2, 0], [0, 4]], k=3))
