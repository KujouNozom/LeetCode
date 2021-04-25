# 778. 水位上升的泳池中游泳
#
# 在一个 N x N 的坐标方格 grid 中，每一个方格的值 grid[i][j] 表示在位置 (i,j) 的平台高度。
# 现在开始下雨了。当时间为 t 时，此时雨水导致水池中任意位置的水位为 t 。你可以从一个平台游向四周相邻的任意一个平台，
# 但是前提是此时水位必须同时淹没这两个平台。假定你可以瞬间移动无限距离，也就是默认在方格内部游动是不耗时的。当然，在你游泳的时候你必须待在坐标方格里面。
# 你从坐标方格的左上平台 (0，0) 出发。最少耗时多久你才能到达坐标方格的右下平台 (N-1, N-1)？
#
# 示例 1:
# 输入: [[0,2],[1,3]]
# 输出: 3
# 解释:
# 时间为0时，你位于坐标方格的位置为 (0, 0)。
# 此时你不能游向任意方向，因为四个相邻方向平台的高度都大于当前时间为 0 时的水位。
# 等时间到达 3 时，你才可以游向平台 (1, 1). 因为此时的水位是 3，坐标方格中的平台没有比水位 3 更高的，所以你可以游向坐标方格中的任意位置
#
# 示例2:
# 输入: [[0,1,2,3,4],[24,23,22,21,5],[12,13,14,15,16],[11,17,18,19,20],[10,9,8,7,6]]
# 输出: 16
# 解释:
#  0  1  2  3  4
# 24 23 22 21  5
# 12 13 14 15 16
# 11 17 18 19 20
# 10  9  8  7  6
#
# 最终的路线用加粗进行了标记。
# 我们必须等到时间为 16，此时才能保证平台 (0, 0) 和 (4, 4) 是连通的
#
# 提示:
#     2 <= N <= 50.
#     grid[i][j] 是 [0, ..., N*N - 1] 的排列。
from typing import List


class Solution:
    def swimInWater(self, grid: List[List[int]]) -> int:
        size = len(grid)
        length = size * size
        # 右 下 左 上
        fws = [[0, 1], [1, 0], [0, -1], [-1, 0]]

        # 这里使用数组存储，开始使用的是dict，后来发现题目中说了n个台子,n种高度....
        high_indexes = [-1] * (length)
        for row, cols in enumerate(grid):
            for col, high in enumerate(cols):
                high_indexes[high] = size * row + col

        union_find = UnionFind(length)
        # 按照高度排序，每次水位到达新的高度，计算这些新被淹没的台子和周围的台子是否相通（周围台子中同样低于水位的台子）
        # 如果相通,就将两个台子的联通集合合并在一起，成为一个集合
        for high in range(length):
            index = high_indexes[high]
            row = index // size
            col = index % size
            for fw in fws:
                row_new = row + fw[0]
                col_new = col + fw[1]
                # 判断新台子和周围的台子是否相连
                index_new = row_new * size + col_new
                if 0 <= row_new < size and 0 <= col_new < size and grid[row_new][col_new] < high:
                    union_find.union(index, index_new)
                    if union_find.check():
                        return high
        return -1


class UnionFind:
    def __init__(self, n):
        self.n = n
        self.parent = [i for i in range(n)]

    def find(self, x: int) -> int:
        parent_x = self.parent[x]
        if parent_x != x:
            self.parent[x] = self.find(parent_x)
        return self.parent[x]

    def union(self, x: int, y: int):
        self.parent[self.find(x)] = self.find(y)

    def check(self) -> bool:
        return self.find(0) == self.find(self.n - 1)
