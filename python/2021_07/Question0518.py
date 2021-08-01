# 518. 零钱兑换 II [动态规划]
from typing import List


class Solution:
    def change(self, amount: int, coins: List[int]) -> int:
        dp = [0] * (amount + 1)
        dp[0] = 1
        for coin in coins:
            for index in range(coin, amount + 1):
                dp[index] += dp[index - coin]
        return dp[amount]