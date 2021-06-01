# 554. 砖墙 [Hash]
from collections import defaultdict
from typing import List


class Solution:
    def leastBricks(self, wall: List[List[int]]) -> int:
        sides = defaultdict(int)
        for row_nums in wall:
            length = 0
            count = len(row_nums)
            for index in range(count - 1):
                length += row_nums[index]
                sides[length] = sides[length] + 1

        return len(wall) - max(sides.values()) if sides else len(wall)