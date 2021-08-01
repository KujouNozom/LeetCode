# 剑指 Offer 53 - I. 在排序数组中查找数字 I [二分查找]
from typing import List


def bir_search_max(values: list, target: int) -> int:
    length = len(values)
    left, right = 0, length
    while left < right:
        mid = (left + right) // 2
        current_value, next_value = values[mid], values[mid + 1] if (mid + 1 < length) else (values[mid] + 1)
        if current_value == target and next_value != target:
            return mid
        if values[mid] <= target:
            left = mid + 1
        else:
            right = mid - 1
    return left


def bir_search_min(values: list, target: int) -> int:
    length = len(values)
    left, right = 0, length
    while left < right:
        mid = (left + right) // 2
        current_value, pre_value = values[mid], values[mid - 1] if (mid - 1 >= 0) else (values[mid] - 1)
        if current_value == target and pre_value != target:
            return mid
        if values[mid] < target:
            left = mid + 1
        else:
            right = mid - 1
    return left


class Solution:
    def search(self, nums: List[int], target: int) -> int:
        left = bir_search_min(nums, target)
        right = bir_search_max(nums, target)
        if left < len(nums) and right < len(nums) and nums[left] == target and nums[right] == target:
            return bir_search_max(nums, target) - bir_search_min(nums, target) + 1
        return 0
