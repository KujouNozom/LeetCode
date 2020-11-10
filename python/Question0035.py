# 标准的二分查找，可以自己实现，也可以使用系统函数
#
# 0035.搜索插入位置
# [简单]
# 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
# 你可以假设数组中无重复元素。
# 示例
# 示例 1
# 输入: [1,3,5,6], 5
# 输出: 2
# 示例 2
# 输入: [1,3,5,6], 2
# 输出: 1
# 示例 3
# 输入: [1,3,5,6], 7
# 输出: 4
# 示例 4
# 输入: [1,3,5,6], 0
# 输出: 0
# 题解

from typing import List


class Solution:
    def searchInsert(self, nums: List[int], target: int) -> int:
        low = 0
        high = len(nums) - 1
        while (low <= high):
            mid = (low + high) // 2
            if nums[mid] == target:
                return mid
            elif nums[mid] < target:
                low = mid + 1
            else:
                high = mid - 1

        return mid if nums[mid] > target else mid + 1

# import bisect
#
#
# class Solution:
#     def searchInsert(self, nums: List[int], target: int) -> int:
#         return bisect.bisect_left(nums, target)
