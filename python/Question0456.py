# 456. 132 模式 [单调栈]
from typing import List


class Solution:
    def find132pattern(self, nums: List[int]) -> bool:
        length = len(nums)
        num_2 = None
        num_3 = [nums[-1]]
        for index in range(length - 2, -1, -1):
            num = nums[index]
            if num_2 and num < num_2:
                return True

            while num_3 and num > num_3[-1]:
                num_2 = num_3.pop()

            if not num_2 or num > num_2:
                num_3.append(num)
        return False
