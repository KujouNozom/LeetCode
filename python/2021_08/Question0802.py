# 802. 找到最终的安全状态 [拓扑排序]
import collections
from typing import List


class Solution:
    def eventualSafeNodes(self, graph: List[List[int]]) -> List[int]:
        length = len(graph)

        graph_reverse = [[] for _ in range(length)]
        for (src, target_list) in enumerate(graph):
            for target in target_list:
                graph_reverse[target].append(src)

        node_count = {index: len(graph[index]) for index in range(length)}
        queue = collections.deque()
        queue.extend([index for index in range(length) if not graph[index]])

        while queue:
            src_list = graph_reverse[queue.pop()]
            for src in src_list:
                node_count[src] -= 1
                if node_count[src] == 0:
                    queue.appendleft(src)

        return list([index for index in range(length) if node_count[index] == 0])
