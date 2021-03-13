# 26. 删除排序数组中的重复项 [双指针]
from typing import List


class Solution:
    def removeDuplicates(self, nums: List[int]) -> int:
        valid_index = 0
        if nums:
            pre = nums[0] - 1
            length = len(nums)
            for index in range(length):
                value = nums[index]
                if value != pre:
                    nums[valid_index] = value
                    valid_index += 1
                    pre = value

        return valid_index
