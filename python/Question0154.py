# 154. 寻找旋转排序数组中的最小值 II [二分查找]
from typing import List


class Solution:
    def findMin(self, nums: List[int]) -> int:
        if len(nums) == 1:
            return nums[0]

        left, right = 0, len(nums) - 1
        while left < right:
            mid = (left + right) // 2

            if nums[mid] == nums[right]:
                right -= 1
            elif nums[mid] < nums[right]:
                right = mid
            else:
                left = mid + 1
        return nums[left]
