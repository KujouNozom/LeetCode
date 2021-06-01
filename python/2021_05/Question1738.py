# 1738. 找出第 K 大的异或坐标值 [位运算，前缀和]
from typing import List


class Solution:
    def kthLargestValue(self, matrix: List[List[int]], k: int) -> int:
        row, col = len(matrix), len(matrix[0])
        pre_sum = [[0] * (col + 1) for _ in range(row + 1)]

        for index_i in range(row):
            for index_j in range(col):
                pre_sum[index_i + 1][index_j + 1] = pre_sum[index_i][index_j] ^ pre_sum[index_i][index_j + 1] ^ \
                                                    pre_sum[index_i + 1][index_j] ^ matrix[index_i][index_j]

        temp = []
        for index_i in range(row):
            temp.extend(pre_sum[index_i + 1])

        return sorted(temp, reverse=True)[k - 1]
