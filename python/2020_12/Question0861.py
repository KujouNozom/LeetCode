# 861. 翻转矩阵后的得分
# [中等]
# 先翻转行，使最高位全部是1，然后遍历后面每一列，如果0的数量大于1，翻转这个列
#
# 有一个二维矩阵 A 其中每个元素的值为 0 或 1 。
# 移动是指选择任一行或列，并转换该行或列中的每一个值：将所有 0 都更改为 1，将所有 1 都更改为 0。
# 在做出任意次数的移动后，将该矩阵的每一行都按照二进制数来解释，矩阵的得分就是这些数字的总和。
# 返回尽可能高的分数。
#
# 示例：
# 输入：[[0,0,1,1],[1,0,1,0],[1,1,0,0]]
# 输出：39
# 解释：
# 转换为 [[1,1,1,1],[1,0,0,1],[1,1,1,1]]
# 0b1111 + 0b1001 + 0b1111 = 15 + 9 + 15 = 39
#
# 提示：
#     1 <= A.length <= 20
#     1 <= A[0].length <= 20
#     A[i][j] 是 0 或 1

from typing import List


def reverse_row(datas: List[List[int]], row):
    for col in range(len(datas[row])):
        datas[row][col] ^= 1


def reverse_col(datas: List[List[int]], col):
    for row in range(len(datas)):
        datas[row][col] ^= 1


class Solution:
    def matrixScore(self, A: List[List[int]]) -> int:
        length_row = len(A)
        length_col = len(A[0])

        for row in range(length_row):
            if not A[row][0]:
                reverse_row(A, row)

        for col in range(1, length_col):
            count_1 = 0
            count_0 = 0
            for row in range(length_row):
                if A[row][col]:
                    count_1 += 1
                else:
                    count_0 += 1

            if count_0 > count_1:
                reverse_col(A, col)

        ans = 0
        for row in range(length_row):
            temp = ''
            for col in range(length_col):
                temp += str(A[row][col])

            ans += int(temp, 2)

        return ans


Solution().matrixScore([[0, 0, 1, 1], [1, 0, 1, 0], [1, 1, 0, 0]])
