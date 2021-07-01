# 773. 滑动谜题 [BFS]
import collections
from typing import List


class Solution:
    def slidingPuzzle(self, board: List[List[int]]) -> int:
        target = '123450'
        start = ''.join(str(row) for row in sum(board, []))
        if start == target:
            return 0

        swaps_list = [[1, 3], [0, 2, 4], [1, 5], [0, 4], [1, 3, 5], [2, 4]]
        queue = collections.deque()
        queue.append((start, 0))
        visited = {start}

        while queue:
            current, step = queue.pop()
            current = list(current)
            index = current.index('0')

            swaps = swaps_list[index]
            for swap in swaps:
                current[index], current[swap] = current[swap], current[index]
                value = ''.join(current)
                if value == target:
                    return step + 1
                if value not in visited:
                    queue.appendleft((value, step + 1))
                    visited.add(value)
                current[index], current[swap] = current[swap], current[index]
        return -1
