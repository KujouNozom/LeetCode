# 剑指 Offer 11. 旋转数组的最小数字 [二分查找]
from typing import List


class Solution:
    def minArray(self, numbers: List[int]) -> int:
        if len(numbers) == 1:
            return numbers[0]

        left, right = 0, len(numbers) - 1
        while left < right:
            mid = (left + right) // 2

            if numbers[mid] == numbers[right]:
                right -= 1
            elif numbers[mid] < numbers[right]:
                right = mid
            else:
                left = mid + 1
        return numbers[left]
