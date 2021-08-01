# 1049. 最后一块石头的重量 II [动态规划]
from typing import List


class Solution:
    def lastStoneWeightII(self, stones: List[int]) -> int:
        total_weight = sum(stones)
        half_weight = total_weight // 2
        length = len(stones)
        dp = [[False] * (half_weight + 1) for _ in range(length + 1)]
        dp[0][0] = True
        for index_stone in range(length):
            for index_weight in range(half_weight + 1):
                if index_weight < stones[index_stone]:
                    dp[index_stone + 1][index_weight] = dp[index_stone][index_weight]
                else:
                    dp[index_stone + 1][index_weight] = dp[index_stone][
                                                            index_weight - stones[index_stone]] or \
                                                        dp[index_stone][index_weight]
        ans = -1
        for index_weight in range(half_weight, -1, -1):
            if dp[length][index_weight]:
                ans = total_weight - 2 * index_weight
                break
        return ans
