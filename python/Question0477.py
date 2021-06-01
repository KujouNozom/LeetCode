# 477. 汉明距离总和 [位运算]
from typing import List


class Solution:
    def totalHammingDistance(self, nums: List[int]) -> int:
        length = len(nums)
        ans = 0
        for index in range(30):
            count_1 = 0
            for num in nums:
                if (num >> index) & 1:
                    count_1 += 1

            ans += count_1 * (length - count_1)

        return ans
