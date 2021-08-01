# 1818. 绝对差值和 [二分查找]
from typing import List


def bin_search(data: list, target: int):
    left, right = 0, len(data) - 1
    ans = len(data) - 1
    while left <= right:
        mid = (left + right) // 2
        if data[mid] >= target:
            ans = mid
            right = mid - 1
        else:
            left = mid + 1

    return ans


class Solution:
    def minAbsoluteSumDiff(self, nums1: List[int], nums2: List[int]) -> int:
        ans, temp = 0, -1
        mod = 10 ** 9 + 7
        length = len(nums1)
        nums1_copy = nums1[:]
        nums1_copy.sort()

        for index in range(length):
            current = abs(nums1[index] - nums2[index])
            ans = (ans + current) % mod

            swap_index = bin_search(nums1_copy, nums2[index])
            temp = max(temp, current - abs(nums1_copy[swap_index] - nums2[index]))
            if swap_index > 0:
                temp = max(temp, current - abs(nums2[index] - nums1_copy[swap_index - 1]))

        return (ans - temp) if (ans - temp) >= 0 else (ans - temp + mod)
