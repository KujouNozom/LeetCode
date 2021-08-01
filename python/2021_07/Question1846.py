# 1846. 减小和重新排列数组后的最大元素 [贪心]
import collections
from typing import List


class Solution:
    def maximumElementAfterDecrementingAndRearranging(self, arr: List[int]) -> int:
        length = len(arr)
        for index, value in enumerate(arr):
            if value > length:
                arr[index] = length

        num_counts = collections.Counter(arr)
        need_count = 0

        for index in range(1, length + 1):
            count = num_counts.get(index, 0)
            if count > 1:
                need_count = min(0, need_count + (count - 1))
            elif count == 0:
                need_count = need_count - 1

        return length + need_count
