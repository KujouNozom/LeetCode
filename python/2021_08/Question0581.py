# 581. 最短无序连续子数组 [单调栈]
from typing import List


class Solution:
    def findUnsortedSubarray(self, nums: List[int]) -> int:
        length = len(nums)

        stack_head, stack_tail = [], []
        for index in range(length):
            value_head, value_tail = nums[index], nums[length - 1 - index]
            while stack_head and stack_head[-1][1] > value_head:
                stack_head.pop()
            while stack_tail and stack_tail[-1][1] < value_tail:
                stack_tail.pop()
            stack_head.append((index, value_head))
            stack_tail.append((length - 1 - index, value_tail))

        if len(stack_head) == length:
            return 0
        ans = 0
        for index in range(len(stack_head)):
            if stack_head[index][0] != index:
                ans += index
                break
        for index in range(len(stack_tail)):

            if stack_tail[index][0] != (length - 1 - index):
                ans += index
                break
        return length - ans
