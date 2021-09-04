# 446. 等差数列划分 II - 子序列 [动态规划]
import collections
from typing import List


class Solution:
    def numberOfArithmeticSlices(self, nums: List[int]) -> int:
        length = len(nums)
        dp = [collections.defaultdict(int) for _ in range(length)]

        ans = 0
        for i in range(length):
            for j in range(i):
                diff = nums[i] - nums[j]
                ans += dp[j][diff]
                dp[i][diff] += dp[j][diff] + 1

        return ans
