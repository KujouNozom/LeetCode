# 118. 杨辉三角
#
# 给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。
#
# 在杨辉三角中，每个数是它左上方和右上方的数的和。
#
# 示例:
#
# 输入: 5
# 输出:
# [
#      [1],
#     [1,1],
#    [1,2,1],
#   [1,3,3,1],
#  [1,4,6,4,1]
# ]
#
# 通过次数125,296
# 提交次数182,789

from typing import List


class Solution:
    def generate(self, numRows: int) -> List[List[int]]:
        if not numRows:
            return []
        ans = [[1]]
        for row in range(1, numRows):
            temp_row = [1]
            for col in range(1, row):
                temp_row.append(ans[row - 1][col - 1] + ans[row - 1][col])
            temp_row.append(1)
            ans.append(temp_row)
        return ans
