# 789. 逃脱阻碍者 [数学]
from typing import List


class Solution:
    def escapeGhosts(self, ghosts: List[List[int]], target: List[int]) -> bool:
        safe_distance = abs(target[0]) + abs(target[1])
        for ghost in ghosts:
            if abs(ghost[0] - target[0]) + abs(ghost[1] - target[1]) <= safe_distance:
                return False
        return True
