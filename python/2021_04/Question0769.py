# 769. 最多能完成排序的块 [双指针]
from typing import List


class Solution:
    def maxChunksToSorted(self, arr: List[int]) -> int:
        min_value, max_value, start = 10, -1, 0

        ans = 0
        for index in range(len(arr)):
            min_value = min(min_value, arr[index])
            max_value = max(max_value, arr[index])
            if min_value == start and max_value == index:
                ans += 1
                min_value, max_value, start = 10, -1, index + 1
        return ans
