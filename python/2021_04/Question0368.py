# 368. 最大整除子集 [动态规划]
from typing import List


class Solution:
    def largestDivisibleSubset(self, nums: List[int]) -> List[int]:
        nums.sort()
        length = len(nums)

        dp = [1] * length
        for index, num in enumerate(nums):
            for i in range(index):
                if num % nums[i] == 0:
                    dp[index] = max(dp[index], dp[i] + 1)

        max_length = max(dp)
        max_value = nums[dp.index(max_length)]

        ans = []

        for index in range(length - 1, -1, -1):
            if dp[index] == max_length and max_value % nums[index] == 0:
                max_length -= 1
                max_value = nums[index]
                ans.append(nums[index])
        return ans