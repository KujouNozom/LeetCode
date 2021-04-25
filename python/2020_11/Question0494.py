# 494.目标和
# [中等]
# 给定一个非负整数数组，a1, a2, ..., an, 和一个目标数，S。现在你有两个符号 + 和 -。对于数组中的任意一个整数，你都可以从 + 或 -中选择一个符号添加在前面。
# 返回可以使最终数组和为目标数 S 的所有添加符号的方法数。
# 示例
# 输入：nums: [1, 1, 1, 1, 1], S: 3
# 输出：5
# 解释：
# -1+1+1+1+1 = 3
# +1-1+1+1+1 = 3
# +1+1-1+1+1 = 3
# +1+1+1-1+1 = 3
# +1+1+1+1-1 = 3
# 一共有5种方法让最终目标和为3。
# 提示
# 数组非空，且长度不会超过 20 。
# 初始的数组的和不会超过 1000 。
# 保证返回的最终结果能被 32 位整数存下。
# 题解
# 动态规划
# 这个题是一个明显的背包问题，类似将物品放到包里和不放到包里，这道题是加上当前数量还是减去当前数量
# dp[i][j]：表示用前面 i 个数字组成和为 j 的方案数量
# 状态转移方程：dp[i][j] = dp[i-1][j-nums[i]] + dp[i-1][j+nums[i]]
# 初始值：全部数组设置为0，dp[0][nums[0]] = 1，dp[1][-nums[0]] = 1（注意如果是0，那么正负号都是0，初始dp[0]n[ums[0]] = 2）
# 最终结果 dp[nums.length-1][target] 就是答案
# 注意：我们需要把数字长度声明为dp[length][2001] 因为数字之和小于等于1000，因此加上正负号范围为 [-1000,1000]。我们需要在计算出每个值之后加上1000，来让和都变成正数

from typing import List


class Solution:
    def findTargetSumWays(self, nums: List[int], S: int) -> int:
        if S > 1000:
            return 0

        length = len(nums)
        dp = []
        for index in range(len(nums)):
            dp.append([0] * 2001)
        if nums[0] == 0:
            dp[0][1000] = 2
        else:
            dp[0][nums[0] + 1000], dp[0][-nums[0] + 1000] = 1, 1

        for i in range(1, length):
            for j in range(-1000, 1001):
                dp[i][j] = dp[i - 1][j - nums[i]] + dp[i - 1][j + nums[i]]

        return dp[len(nums) - 1][S + 1000]
