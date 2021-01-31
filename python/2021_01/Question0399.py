# 399. 除法求值
#
# 给你一个变量对数组 equations 和一个实数值数组 values 作为已知条件，
# 其中 equations[i] = [Ai, Bi] 和 values[i] 共同表示等式 Ai / Bi = values[i] 。每个 Ai 或 Bi 是一个表示单个变量的字符串。
# 另有一些以数组 queries 表示的问题，其中 queries[j] = [Cj, Dj] 表示第 j 个问题，请你根据已知条件找出 Cj / Dj = ? 的结果作为答案。
# 返回 所有问题的答案 。如果存在某个无法确定的答案，则用 -1.0 替代这个答案。
# 注意：输入总是有效的。你可以假设除法运算中不会出现除数为 0 的情况，且不存在任何矛盾的结果。
#
# 示例 1：
# 输入：equations = [["a","b"],["b","c"]], values = [2.0,3.0], queries = [["a","c"],["b","a"],["a","e"],["a","a"],["x","x"]]
# 输出：[6.00000,0.50000,-1.00000,1.00000,-1.00000]
# 解释：
# 条件：a / b = 2.0, b / c = 3.0
# 问题：a / c = ?, b / a = ?, a / e = ?, a / a = ?, x / x = ?
# 结果：[6.0, 0.5, -1.0, 1.0, -1.0 ]
#
# 示例 2：
# 输入：equations = [["a","b"],["b","c"],["bc","cd"]], values = [1.5,2.5,5.0], queries = [["a","c"],["c","b"],["bc","cd"],["cd","bc"]]
# 输出：[3.75000,0.40000,5.00000,0.20000]
#
# 示例 3：
# 输入：equations = [["a","b"]], values = [0.5], queries = [["a","b"],["b","a"],["a","c"],["x","y"]]
# 输出：[0.50000,2.00000,-1.00000,-1.00000]
#
# 提示：
#     1 <= equations.length <= 20
#     equations[i].length == 2
#     1 <= Ai.length, Bi.length <= 5
#     values.length == equations.length
#     0.0 < values[i] <= 20.0
#     1 <= queries.length <= 20
#     queries[i].length == 2
#     1 <= Cj.length, Dj.length <= 5
#     Ai, Bi, Cj, Dj 由小写英文字母与数字组成
from typing import List


class Solution:
    def calcEquation(self, equations: List[List[str]], values: List[float], queries: List[List[str]]) -> List[float]:
        union_find_weight = UnionFindWeight()
        for index, equation in enumerate(equations):
            v1 = equation[0]
            v2 = equation[1]
            union_find_weight.union(v1, v2, values[index])
        ans = []

        for querie in queries:
            v1 = querie[0]
            v2 = querie[1]
            ans.append(union_find_weight.get_ans(v1, v2))

        return ans


class UnionFindWeight:
    def __init__(self):
        self.weight = {}
        self.parent = {}
        self.elements = {}

    def findf(self, x: str) -> str:
        parent_x = self.parent.get(x, x)
        if parent_x != x:
            temp = self.findf(parent_x)
            self.parent[x] = temp
            self.weight[x] *= self.weight.get(parent_x, 1)
        return self.parent.get(x, x)

    def union(self, x: str, y: str, value: float):
        self.elements[x] = 1
        self.elements[y] = 1
        parent_x = self.findf(x)
        parent_y = self.findf(y)
        if parent_x != parent_y:
            self.parent[parent_x] = parent_y
            self.weight[parent_x] = self.weight.get(y, 1) * value / self.weight.get(x, 1)

    def get_ans(self, x: str, y: str) -> float:
        if x not in self.elements.keys() or y not in self.elements.keys():
            return -1.0
        parent_x = self.findf(x)
        parent_y = self.findf(y)
        if parent_x == parent_y:
            return self.weight.get(x, 1) / self.weight.get(y, 1)
        else:
            return -1.0