# 1838. 最高频元素的频数 [滑动窗口]
from typing import List


class Solution:
    def maxFrequency(self, nums: List[int], k: int) -> int:
        left, current_k = 0, 0
        nums.sort()
        ans = 1
        for right in range(1, len(nums)):
            current_k = current_k + (nums[right] - nums[right - 1]) * (right - left)
            if current_k > k:
                current_k = current_k - (nums[right] - nums[left])
                left += 1

            if current_k <= k:
                ans = right - left + 1
        return ans
