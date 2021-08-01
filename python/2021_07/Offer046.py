# 剑指 Offer 42. 连续子数组的最大和 [动态规划]
from typing import List


class Solution:
    def maxSubArray(self, nums: List[int]) -> int:
        dp = [0] * len(nums)
        dp[0] = nums[0]
        for index in range(1, len(nums)):
            dp[index] = dp[index - 1] + nums[index] if dp[index - 1] > 0 else nums[index]
        return max(dp)
