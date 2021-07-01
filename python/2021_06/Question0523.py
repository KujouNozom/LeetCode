# 523. 连续的子数组和 [前缀和，同余定理]
from typing import List


class Solution:
    def checkSubarraySum(self, nums: List[int], k: int) -> bool:
        if len(nums) < 2:
            return False
        pre_sums = [0]
        for num in nums:
            pre_sums.append(pre_sums[-1] + num)
        remainders = {}
        for index, pre_sum in enumerate(pre_sums):
            remainder = remainders.get(pre_sum % k, -1)
            if remainder == -1:
                remainders[pre_sum % k] = index
            elif index - remainder >= 2:
                return True

        return False


print(Solution().checkSubarraySum([5, 0, 0, 0], 3))
