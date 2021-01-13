# 684. 冗余连接
#
# 在本问题中, 树指的是一个连通且无环的无向图。
# 输入一个图，该图由一个有着N个节点 (节点值不重复1, 2, ..., N) 的树及一条附加的边构成。附加的边的两个顶点包含在1到N中间，这条附加的边不属于树中已存在的边。
# 结果图是一个以边组成的二维数组。每一个边的元素是一对[u, v] ，满足 u < v，表示连接顶点u 和v的无向图的边。
# 返回一条可以删去的边，使得结果图是一个有着N个节点的树。如果有多个答案，则返回二维数组中最后出现的边。答案边 [u, v] 应满足相同的格式 u < v。
#
# 示例 1：
# 输入: [[1,2], [1,3], [2,3]]
# 输出: [2,3]
# 解释: 给定的无向图为:
#   1
#  / \
# 2 - 3
#
# 示例 2：
# 输入: [[1,2], [2,3], [3,4], [1,4], [1,5]]
# 输出: [1,4]
# 解释: 给定的无向图为:
# 5 - 1 - 2
#     |   |
#     4 - 3
#
# 注意:
#     输入的二维数组大小在 3 到 1000。
#     二维数组中的整数在1到N之间，其中N是输入数组的大小。
#
# 更新(2017-09-26):
# 我们已经重新检查了问题描述及测试用例，明确图是无向 图。对于有向图详见冗余连接II。对于造成任何不便，我们深感歉意。
from typing import List


class Solution:
    def findRedundantConnection(self, edges: List[List[int]]) -> List[int]:
        union_find = UnionFind(len(edges) + 1)
        ans = []
        for edge in edges:
            parent0 = union_find.find(edge[0])
            parent1 = union_find.find(edge[1])
            if parent0 == parent1:
                ans = edge

            union_find.union(edge[0], edge[1])
        return ans


class UnionFind:
    def __init__(self, n):
        self.parent = [i for i in range(n)]

    def find(self, x: int) -> int:
        parent_x = self.parent[x]
        if parent_x != x:
            self.parent[x] = self.find(parent_x)
        return self.parent[x]

    def union(self, x: int, y: int):
        self.parent[self.find(x)] = self.find(y)

    def get_collections(self, n) -> dict:
        res = {}
        for index in range(n):
            parent_x = self.find(index)
            coll = res.get(parent_x, [])
            coll.append(index)
            res[parent_x] = coll
        return res
