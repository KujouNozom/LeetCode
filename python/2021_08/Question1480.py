# 1480. 一维数组的动态和 [前缀和]
from typing import List


class Solution:
    def runningSum(self, nums: List[int]) -> List[int]:
        ans = []
        pre_sum = 0
        for num in nums:
            pre_sum += num
            ans.append(pre_sum)
        return ans
