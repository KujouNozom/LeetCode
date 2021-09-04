# 611. 有效三角形的个数 [二分查找]
from typing import List


def bin_search(i: int, j: int, length: int, nums: list):
    target = j
    left, right = j + 1, length - 1
    while left <= right:
        mid = (left + right) // 2
        if nums[mid] < nums[i] + nums[j]:
            target = mid
            left = mid + 1
        else:
            right = mid - 1
    return target - j


class Solution:
    def triangleNumber(self, nums: List[int]) -> int:
        length = len(nums)
        nums.sort()
        ans = 0
        for i in range(length):
            for j in range(i + 1, length):
                ans += bin_search(i, j, length, nums)
        return ans
