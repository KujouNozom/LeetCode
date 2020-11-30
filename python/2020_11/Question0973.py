# 这里我们使用两个坐标的平方之和表示距离，因为不需要考虑正负和小数点
# 我们使用优先级队列存储最小的 k 个数字对应的下标。
# 这里我使用 Python3 我们先转换为一个(距离, 下标)的集合，然后将它转换为一个堆，最后利用堆的方法，获取最小的 K 个下标
#
# 973.最接近原点的 K 个点
# 我们有一个由平面上的点组成的列表 points。需要从中找出 K 个距离原点 (0, 0) 最近的点。
# （这里，平面上两点之间的距离是欧几里德距离。）
# 你可以按任何顺序返回答案。除了点坐标的顺序之外，答案确保是唯一的。
# 示例
# 示例 1
# 输入：points = [[1,3],[-2,2]], K = 1
# 输出：[[-2,2]]
# 解释：
# (1, 3) 和原点之间的距离为 sqrt(10)，
# (-2, 2) 和原点之间的距离为 sqrt(8)，
# 由于 sqrt(8) < sqrt(10)，(-2, 2) 离原点更近。
# 我们只需要距离原点最近的 K = 1 个点，所以答案就是 [[-2,2]]。
# 示例 2
# 输入：points = [[3,3],[5,-1],[-2,4]], K = 2
# 输出：[[3,3],[-2,4]]
# （答案 [[-2,4],[3,3]] 也会被接受。）
# 提示
# 1 <= K <= points.length <= 10000
# -10000 < points[i][0] < 10000
# -10000 < points[i][1] < 10000

import heapq
from typing import List


class Solution:
    def kClosest(self, points: List[List[int]], K: int) -> List[List[int]]:
        dist_list = [(point[0] ** 2 + point[1] ** 2, i) for i, point in enumerate(points)]
        heapq.heapify(dist_list)
        ans = [points[i] for (_, i) in heapq.nsmallest(K, dist_list)]
        return ans


Solution().kClosest([[3, 3], [5, -1], [-2, 4]], 2)
