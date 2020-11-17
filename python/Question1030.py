# 1030.距离顺序排列矩阵单元格
# 给出 R 行 C 列的矩阵，其中的单元格的整数坐标为 (r, c)，满足 0 <= r < R 且 0 <= c < C。
# 另外，我们在该矩阵中给出了一个坐标为 (r0, c0) 的单元格。
# 返回矩阵中的所有单元格的坐标，并按到 (r0, c0) 的距离从最小到最大的顺序排，其中，两单元格(r1, c1) 和 (r2, c2) 之间的距离是曼哈顿距离，|r1 - r2| + |c1 - c2|。（你可以按任何满足此条件的顺序返回答案。）
# 示例
# 示例 1
# 输入：R = 1, C = 2, r0 = 0, c0 = 0
# 输出：[[0,0],[0,1]]
# 解释：从 (r0, c0) 到其他单元格的距离为：[0,1]
# 示例 2
# 输入：R = 2, C = 2, r0 = 0, c0 = 1
# 输出：[[0,1],[0,0],[1,1],[1,0]]
# 解释：从 (r0, c0) 到其他单元格的距离为：[0,1,1,2]
# [[0,1],[1,1],[0,0],[1,0]] 也会被视作正确答案。
# 示例 3
# 输入：R = 2, C = 3, r0 = 1, c0 = 2
# 输出：[[1,2],[0,2],[1,1],[0,1],[1,0],[0,0]]
# 解释：从 (r0, c0) 到其他单元格的距离为：[0,1,1,2,2,3]
# 其他满足题目要求的答案也会被视为正确，例如 [[1,2],[1,1],[0,2],[1,0],[0,1],[0,0]]。
# 提示
# 1 <= R <= 100
# 1 <= C <= 100
# 0 <= r0 < R
# 0 <= c0 < C
# 题解
# 遍历数组，计算所有点到目标点的距离，然后存储到 Map 中
# 之后根据映射的大小，从小到大获取所有距离（距离一定是从 0 开始的，间隔 1 的数列）的点集合，然后添加的结果集中


from typing import List


class Solution:
    def allCellsDistOrder(self, R: int, C: int, r0: int, c0: int) -> List[List[int]]:
        distances = {}
        for i in range(R):
            for j in range(C):
                distance = abs(i - r0) + abs(j - c0)
                temp = distances.get(distance, [])
                temp.append([i, j])
                distances[distance] = temp

        ans = []
        for index in range(len(distances)):
            temp = distances.get(index, [])
            if tuple:
                ans += temp
        return ans


Solution().allCellsDistOrder(1, 2, 0, 0)
