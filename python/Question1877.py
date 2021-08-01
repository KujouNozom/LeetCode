# 1877. 数组中最大数对和的最小值 [数学，贪心算法]
from typing import List


class Solution:
    def minPairSum(self, nums: List[int]) -> int:
        nums.sort()
        ans = -1
        length = len(nums)
        for index in range(length // 2):
            ans = max(ans, nums[index] + nums[length - 1 - index])
        return ans
