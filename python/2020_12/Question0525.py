# 525. 连续数组
#
# 给定一个二进制数组, 找到含有相同数量的 0 和 1 的最长连续子数组（的长度）。
#
# 示例 1:
# 输入: [0,1]
# 输出: 2
# 说明: [0, 1] 是具有相同数量0和1的最长连续子数组。
#
# 示例 2:
# 输入: [0,1,0]
# 输出: 2
# 说明: [0, 1] (或 [1, 0]) 是具有相同数量0和1的最长连续子数组。
#
# 注意: 给定的二进制数组的长度不会超过50000。

from typing import List


class Solution:
    def findMaxLength(self, nums: List[int]) -> int:
        count = 0
        ans = 0
        insedex = {0: -1}

        for index, num in enumerate(nums):
            if num:
                count += 1
            else:
                count -= 1
            ans = max(index - insedex.get(count, index), ans)
            if not count in insedex.keys():
                insedex[count] = index
        return ans


Solution().findMaxLength([0, 1, 0, 1])
