# 0149. 直线上最多的点数
# 给定一个二维平面，平面上有 n 个点，求最多有多少个点在同一条直线上。
#
# 示例
# 示例 1
# 输入: [[1,1],[2,2],[3,3]]
# 输出: 3
#
# 示例 2
# 输入: [[1,1],[3,2],[5,3],[4,1],[2,3],[1,4]]
# 输出: 4


from math import gcd
from typing import List
from fractions import Fraction


class Solution:
    def maxPoints(self, points: List[List[int]]) -> int:
        global datas, length
        datas = points
        length = len(points)

        # 点数小于2，肯定在一条直线上面
        if length <= 2:
            return length

        # 遍历每个点，获取包含当前点的最多点直线的点数量
        max_count = 1
        for i in range(length - 1):
            max_count = max(max_count, Solution.get_max_count(i))
        return max_count

    def get_max_count(i) -> int:
        global datas, length

        # 保存过这个点的每个斜率的直线包含的线的个数
        # invalid表示斜率为无效值,duplicate_count表示重合的点个数
        counts = {'invalid': 1, 'duplicate_count': 0}

        x1 = datas[i][0]
        y1 = datas[i][1]

        for j in range(i + 1, length):
            Solution.cal_count(x1, y1, j, counts)

        duplicate_count = counts.pop('duplicate_count')
        return max(counts.values()) + duplicate_count

    def cal_count(x1, y1, j, counts):
        global datas, length
        x2 = datas[j][0]
        y2 = datas[j][1]
        if x1 == x2 and y1 == y2:
            counts['duplicate_count'] += 1
        elif y1 == y2:
            counts['invalid'] += 1
        else:
            num1 = x1 - x2
            num2 = y1 - y2
            g = gcd(num1, num2)

            slope = Fraction(num1 // g, num2 // g)
            counts[slope] = counts.get(slope, 1) + 1


Solution().maxPoints([[1, 1], [3, 2], [5, 3], [4, 1], [2, 3], [1, 4]])
