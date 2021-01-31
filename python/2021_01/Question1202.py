# 1202. 交换字符串中的元素
#
# 给你一个字符串 s，以及该字符串中的一些「索引对」数组 pairs，其中 pairs[i] = [a, b] 表示字符串中的两个索引（编号从 0 开始）。
# 你可以 任意多次交换 在 pairs 中任意一对索引处的字符。
# 返回在经过若干次交换后，s 可以变成的按字典序最小的字符串。
#
# 示例 1:
# 输入：s = "dcab", pairs = [[0,3],[1,2]]
# 输出："bacd"
# 解释：
# 交换 s[0] 和 s[3], s = "bcad"
# 交换 s[1] 和 s[2], s = "bacd"
#
# 示例 2：
# 输入：s = "dcab", pairs = [[0,3],[1,2],[0,2]]
# 输出："abcd"
# 解释：
# 交换 s[0] 和 s[3], s = "bcad"
# 交换 s[0] 和 s[2], s = "acbd"
# 交换 s[1] 和 s[2], s = "abcd"
#
# 示例 3：
# 输入：s = "cba", pairs = [[0,1],[1,2]]
# 输出："abc"
# 解释：
# 交换 s[0] 和 s[1], s = "bca"
# 交换 s[1] 和 s[2], s = "bac"
# 交换 s[0] 和 s[1], s = "abc"
#
# 提示：
#     1 <= s.length <= 10^5
#     0 <= pairs.length <= 10^5
#     0 <= pairs[i][0], pairs[i][1] < s.length
#     s 中只含有小写英文字母
from typing import List


class Solution:
    def smallestStringWithSwaps(self, s: str, pairs: List[List[int]]) -> str:
        length = len(s)
        union_find = UnionFind(length)
        for pair in pairs:
            union_find.union(pair[0], pair[1])

        collections = union_find.get_collections(length)

        ans = [''] * length
        for indexes in collections.values():
            temp = [s[index] for index in indexes]
            temp.sort()
            for sorted_index, value in enumerate(sorted(indexes)):
                ans[value] = temp[sorted_index]

        return ''.join(ans)


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
