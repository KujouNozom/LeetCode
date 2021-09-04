# 743. 网络延迟时间 [最短路径、迪杰斯特拉算法]
import collections
from typing import List


def select_node(starts: dict, ends: dict):
    min_path_index, min_path_value = -1, float('inf')
    for key, value in ends.items():
        if value < min_path_value:
            min_path_index, min_path_value = key, value
    if min_path_index != -1:
        ends.pop(min_path_index)
    else:
        min_path_index, min_path_value = ends.popitem()
    starts[min_path_index] = min_path_value
    return min_path_index, min_path_value


def update_ends(ends, min_path_index, min_path_value, sides):
    side = sides.get(min_path_index, None)
    if side:
        for key, value in side.items():
            if ends.get(key, None):
                ends[key] = min(ends[key], min_path_value + value)


class Solution:
    def networkDelayTime(self, times: List[List[int]], n: int, k: int) -> int:
        ends = {n: float('inf') for n in range(1, n + 1)}
        sides = collections.defaultdict(dict)
        for time in times:
            sides[time[0]][time[1]] = time[2]
        ends[k] = 0
        starts = {}

        while ends:
            min_path_index, min_path_value = select_node(starts, ends)
            update_ends(ends, min_path_index, min_path_value, sides)

        ans = max(starts.values())
        return ans if ans != float('inf') else -1
