import bisect
from typing import List


class Solution:
    def countRangeSum(self, nums: List[int], lower: int, upper: int) -> int:
        sumpres = [0]
        current_sum = 0
        ans = 0
        for n in nums:
            current_sum += n
            ans += bisect.bisect_right(sumpres, current_sum - lower) - bisect.bisect_left(sumpres, current_sum - upper)
            bisect.insort(sumpres, current_sum)
        return ans
