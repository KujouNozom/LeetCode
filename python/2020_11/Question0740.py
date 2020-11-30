# 删除与获得点数
# [中等]
# 给定一个整数数组 nums ，你可以对它进行一些操作。
# 每次操作中，选择任意一个 nums[i] ，删除它并获得 nums[i] 的点数。之后，你必须删除每个等于 nums[i] - 1 或 nums[i] + 1 的元素。
# 开始你拥有 0 个点数。返回你能通过这些操作获得的最大点数。
# 示例
# 示例 1
# 输入: nums = [3, 4, 2]
# 输出: 6
# 解释:
# 删除 4 来获得 4 个点数，因此 3 也被删除。
# 之后，删除 2 来获得 2 个点数。总共获得 6 个点数。
# 示例 2
# 输入: nums = [2, 2, 3, 3, 3, 4]
# 输出: 9
# 解释:
# 删除 3 来获得 3 个点数，接着要删除两个 2 和 4 。
# 之后，再次删除 3 获得 3 个点数，再次删除 3 获得 3 个点数。
# 总共获得 9 个点数。
# 注意
# nums的长度最大为20000。
# 每个整数nums[i]的大小都在[1, 10000]范围内。
# 题解
# 动态规划
# 首先计算所有数字出现的次数，index[] 表示所有出现的数字，升序排序
# dp[i][0]：表示前 i 个数字，删除第 i 个的时候的最大值
# dp[i][1]：表示前 i 个数字，不删除第 i 个的时候的最大值
# 状态转移方程
# 如果 index[i] != index[i-1]，说明 i 和 i-1 不影响
# dp[index][1] = max(dp[index - 1][0], dp[index - 1][1])
# dp[index][0] = dp_temp[1] + value
# 如果 index[i] == index[i-1]，说明 i 和 i-1 相互影响
# dp[index][0] = dp[index - 1][1] + value
# dp[index][1] = max(dp[index - 1][0], dp[index - 1][1])
# 初始状态：dp[0][0] = indexs[0] * counts[indexs[0]；dp[0][1] = 0
# 最终结果：max(dp[len(indexs) - 1][0], dp[len(indexs) - 1][1])

import collections
from typing import List


class Solution:
    def deleteAndEarn(self, nums: List[int]) -> int:
        if not nums:
            return 0
        counts = dict(collections.Counter(nums))
        indexs = list(counts.keys())
        indexs.sort()

        dp = [[indexs[0] * counts[indexs[0]], 0]]
        for index in range(1, len(indexs)):
            dp_temp = [0, 0]
            value = indexs[index] * counts[indexs[index]]
            if indexs[index] != indexs[index - 1] + 1:
                dp_temp[1] = max(dp[index - 1][0], dp[index - 1][1])
                dp_temp[0] = dp_temp[1] + value
            else:
                dp_temp[0] = dp[index - 1][1] + value
                dp_temp[1] = max(dp[index - 1][0], dp[index - 1][1])
            dp.append(dp_temp)

        return max(dp[len(indexs) - 1][0], dp[len(indexs) - 1][1])
