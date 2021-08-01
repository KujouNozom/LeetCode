# 930. 和相同的二元子数组 [前缀和]
from typing import List


class Solution:
    def numSubarraysWithSum(self, nums: List[int], goal: int) -> int:
        a = [-1] + [i for i, v in enumerate(nums) if v == 1] + [len(nums)]
        if goal:
            return sum([(a[i] - a[i - 1]) * (a[i + goal] - a[i + goal - 1]) for i in range(1, len(a) - goal)])
        else:
            return sum([(a[i] - a[i - 1]) * (a[i] - a[i - 1] - 1) // 2 for i in range(1, len(a))])