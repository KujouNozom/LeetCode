# 81. 搜索旋转排序数组 II [二分查找]
from typing import List


class Solution:
    def search(self, nums: List[int], target: int) -> bool:
        if not nums:
            return False

        length, left, right = len(nums), 0, len(nums) - 1
        if length == 1:
            return nums[0] == target

        while left <= right:
            mid = (left + right) // 2
            if nums[mid] == target:
                return True
            if nums[left] == nums[mid] and nums[mid] == nums[right]:
                left += 1
                right -= 1
                continue

            if nums[left] <= nums[mid]:
                if nums[left] <= target < nums[mid]:
                    right = mid - 1
                else:
                    left = mid + 1
            else:
                if nums[mid] < target <= nums[right]:
                    left = mid + 1
                else:
                    right = mid - 1
        return False
