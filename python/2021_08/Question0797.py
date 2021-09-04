# 797. 所有可能的路径 [回溯]
from typing import List


class Solution:
    def allPathsSourceTarget(self, graph: List[List[int]]) -> List[List[int]]:
        def track_back(node: int):
            if node == length - 1:
                ans.append(path[:])
            next_node_list = graph[node]
            for next_node in next_node_list:
                if next_node not in path:
                    path.append(next_node)
                    track_back(next_node)
                    path.pop()

        ans, path = [], [0]
        length = len(graph)
        track_back(0)
        return ans
