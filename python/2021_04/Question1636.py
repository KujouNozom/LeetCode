# 1636. 按照频率将数组升序排序 [排序]
import collections
import functools
from typing import List


class Solution:
    def frequencySort(self, nums: List[int]) -> List[int]:
        def comp(a, b) -> int:
            return 1 if a[1] > b[1] or (a[1] == b[1] and a[0] < b[0]) else -1

        counts = list(dict(collections.Counter(nums)).items())
        sorted_data = sorted(counts, key=functools.cmp_to_key(comp))

        ans = []
        for num, count in sorted_data:
            ans.extend([num] * count)

        return ans
