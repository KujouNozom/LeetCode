# 动态规划
# 推广到和为k的整数倍的最大和
# dp[i][j]：表示前 i 个数字和除以 k 余数是 j 的最大和
# dp[i][j] = max(dp[i-1][j]，dp[i-1][y] + num，dp[i][j])  其中 y 是所有 dp[i-1][y] + num % k = j 的索引
# 初始化 dp[0][] 数组所有值为0
# 注意：每次都要使用 dp[i-1] 数组和计算完成的 dp[i] 数组取最大值来更新 dp[i]，因为 i 位置是数字和前面的 dp 数字中的数字之和除以 k，约数没有等于 j 的，这个时候把前一轮的值平移到这一轮
#
# 1262.可被三整除的最大和
# 给你一个整数数组 nums，请你找出并返回能被三整除的元素最大和。
# 示例
# 示例 1
# 输入：nums = [3,6,5,1,8]
# 输出：18
# 解释：选出数字 3, 6, 1 和 8，它们的和是 18（可被 3 整除的最大和）。
# 示例 2
# 输入：nums = [4]
# 输出：0
# 解释：4 不能被 3 整除，所以无法选出数字，返回 0。
# 示例 3
# 输入：nums = [1,2,3,4,4]
# 输出：12
# 解释：选出数字 1, 3, 4 以及 4，它们的和是 12（可被 3 整除的最大和）。
# 提示
# 1 <= nums.length <= 4 * 10^4
# 1 <= nums[i] <= 10^4
from typing import List


class Solution:
    def maxSumDivThree(self, nums: List[int]) -> int:
        dp = [[0] * 3]
        for num in nums:
            temp = [0] * 3
            for index in range(3):
                sum = dp[len(dp) - 1][index] + num
                k = sum % 3
                temp[k] = max(dp[len(dp) - 1][k], sum, temp[k])
            for index in range(3):
                temp[index] = max(dp[len(dp) - 1][index], temp[index])

            dp.append(temp)

        return dp.pop()[0]
