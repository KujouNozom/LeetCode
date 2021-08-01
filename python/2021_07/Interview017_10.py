# 面试题 17.10. 主要元素 [摩尔投票法]
from typing import List


class Solution:
    def majorityElement(self, nums: List[int]) -> int:
        current_value, current_count = -1, 0
        for index, value in enumerate(nums):
            if current_count:
                if current_value == value:
                    current_count += 1
                else:
                    current_count -= 1
            else:
                current_value, current_count = value, 1

        if current_count:
            sum_value = sum([1 for num in nums if num == current_value])
            return current_value if sum_value > len(nums) // 2 else -1
        return -1


print(Solution().majorityElement([2, 2, 1, 1, 1, 2, 2]))
