# 1893. 检查是否区域内所有整数都被覆盖 [差分数组，前缀和]
from typing import List


class Solution:
    def isCovered(self, ranges: List[List[int]], left: int, right: int) -> bool:
        diff = [0] * 52
        for range_value in ranges:
            diff[range_value[0]] += 1
            diff[range_value[1] + 1] -= 1

        value = sum(diff[:left])
        for index in range(left, right + 1):
            value += diff[index]
            if value <= 0:
                return False

        return True
